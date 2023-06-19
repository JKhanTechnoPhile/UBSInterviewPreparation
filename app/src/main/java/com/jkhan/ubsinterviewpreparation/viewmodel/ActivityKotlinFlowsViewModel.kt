package com.jkhan.ubsinterviewpreparation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

/*
1. Cold Flow - flow will only emit if there is an observer attached, ex: flow
2. Hot Flow - flow will start emitting value even if there is no observer attached
 */

/*
1. State Flow - keeps last value to supply ( consider to be an hot flow )
2. Shared Flow - ( consider to be an hot flow )
 */

class ActivityKotlinFlowsViewModel: ViewModel() {

//    Cold in nature , Return individual flow for each collector so it will return from first
    val countDownFlow = flow<Int> {
        val startingValue = 10
        var currentValue = startingValue

        emit(startingValue)

        while (currentValue > 0) {
            delay(1000L)
            currentValue--
            emit(currentValue)
        }
    }.catch {
        println("Emitter Catch: $it")
        emit(-1)
    }

//    Hot in nature - Return single flow for multiple collector, If consumer join late the data will be last so for emitted but it will hold last emitted value in buffer/cache
    private val _stateFlow = MutableStateFlow(0)
    val stateFlow = _stateFlow.asStateFlow()

//    Hot in nature - Return single flow for multiple collector, If consumer join late the data will be last so for emitted
    private val _sharedFlow = MutableSharedFlow<Int>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    init {
//        collectFlow()
        viewModelScope.launch {
            sharedFlow.collect {
                delay(2000L)
                println("First Flow: The received number is: $it")
            }
        }

        viewModelScope.launch {
            sharedFlow.collect {
                delay(3000L)
                println("Second Flow: The received number is: $it")
            }
        }
        squareNumber(3)
    }

    fun squareNumber(number: Int) {
        viewModelScope.launch {
            _sharedFlow.emit(number * number)
        }
    }

    fun incrementCounter() {
        _stateFlow.value += 1
    }

    private fun collectFlow() {
        viewModelScope.launch {
            countDownFlow
                .filter { time ->
                    time % 2 == 0
                }
                .map { time ->
                    time * time
                }
                .onEach {
                    println("$it")
                }
                .flowOn(Dispatchers.IO)
                .collect { time ->
                println("The current time is :$time")
            }
        }
    }

    private fun consumerSharedFlow() {
        GlobalScope.launch {
            val consumer1 = producerSharedFlow()
            consumer1.collect {
                println("From collector-1: $it")
            }
        }

        GlobalScope.launch {
            val consumer2 = producerSharedFlow()
            delay(2500)
            consumer2.collect {
                println("From collector-1: $it")
            }
        }
    }

    private fun consumerStateFlow() {
        GlobalScope.launch {
            val consumer1 = producerStateFlow()
            consumer1.collect {
                println("From collector-1: $it")
            }
        }

        GlobalScope.launch {
            val consumer2 = producerStateFlow()
            delay(2500)
            consumer2.collect {
                println("From collector-1: $it")
            }
        }
    }

    private fun producerSharedFlow(): Flow<Int> {
//        reply - number of items to be cache so it can share items from there
        val mutableSharedFlow = MutableSharedFlow<Int>(1)
        viewModelScope.launch {
            val list = listOf<Int>(1,2,3,4,5)
            list.forEach {
                mutableSharedFlow.emit(it)
                delay(1000L)
            }
        }

        return mutableSharedFlow
    }

    private fun producerStateFlow(): Flow<Int> {
//        Need to pass an initial value
        val mutableStateFlow = MutableStateFlow<Int>(1)
        viewModelScope.launch {
            val list = listOf<Int>(1,2,3,4,5)
            list.forEach {
                mutableStateFlow.emit(it)
//                mutableStateFlow.value = it // Thread-Safe and can be used by concurrent coroutines and used to get the value instead of collect
                delay(1000L)
            }
        }

        return mutableStateFlow
    }
}