package com.jkhan.ubsinterviewpreparation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.jkhan.ubsinterviewpreparation.viewmodel.ActivityKotlinFlowsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

//https://www.youtube.com/watch?v=ZX8VsqNO_Ss&list=PLQkwcJG4YTCQHCppNAQmLsj_jW38rU9sC
/*
1. Its a kotlin language feature that serves as a reactive programming framework
2. its all about being notified about changes in your code and sending them through a pipeline that potentially modifies them
3. A flow is a coroutine that can emit multiple values over a period of time
 */
class ActivityKotlinFlows : AppCompatActivity() {

    private lateinit var countDownTextView: AppCompatTextView
    private lateinit var countDownButton: AppCompatButton

//    private lateinit var viewModel: ActivityKotlinFlowsViewModel
    private val viewModel by viewModels<ActivityKotlinFlowsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_flows)

//        viewModel = ViewModelProvider(this).get(ActivityKotlinFlowsViewModel::class.java)
        countDownTextView = findViewById(R.id.countDownTv)
//        lifecycleScope.launch(Dispatchers.Main) {
//            viewModel.countDownFlow.map { it * 2 }.filter { it % 2 == 0 }.collect {
//                countDownTextView.text = it.toString()
//            }
//        }

        countDownButton = findViewById(R.id.count_btn)
        countDownButton.setOnClickListener {
            viewModel.incrementCounter()
        }

        collectLatestLifecycleStateFlow(viewModel.stateFlow) {
            countDownTextView.text = it.toString()
        }

        collectLatestLifecycleSharedFlow(viewModel.sharedFlow) {
            countDownTextView.text = it.toString()
        }
//        lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.STARTED) {
//                viewModel.stateFlow.collectLatest {
//                    countDownTextView.text = it.toString()
//                }
//            }
//        }
    }
}

fun <T> AppCompatActivity.collectLatestLifecycleStateFlow(flow: Flow<T>, collect: suspend (T) -> Unit) {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow.collectLatest(collect)
        }
    }
}

fun <T> AppCompatActivity.collectLatestLifecycleSharedFlow(flow: Flow<T>, collect: suspend (T) -> Unit) {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow.collect(collect)
        }
    }
}