package com.jk.coroutines

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Exception

/*
https://kotlinlang.org/docs/coroutines-basics.html#scope-builder
https://www.youtube.com/watch?v=ShNhJ3wMpvQ&list=PLQkwcJG4YTCQcFEPuYGuv54nYai_lwil_
https://developer.android.com/kotlin/coroutines
https://developer.android.com/kotlin/coroutines/coroutines-adv
https://kt.academy/article/cc-dispatchers

Coroutines helps to implement functionality that can be suspended & later resumed at specified points without blocking the thread

1. Coroutine Scope - Defines the life time of coroutines
2. Coroutine Context - On which thread coroutines should execute
 */

//fun main() = runBlocking {
//    println("Inside Main Block")
//    val job = launch(Dispatchers.Default) {
//        delay(1000L)
//        println("Inside Launch Block")
//    }
//    job.join()
//    println("Inside Main Block before finish")
//}

//suspend fun main() = coroutineScope {
//    println("Inside Main Block")
//    val job = launch(Dispatchers.Default) {
//        println("Inside Launch Block")
//        val time = measureTimeMillis {
//            //        withTimeout(3000L) {
//            repeat(30) {
//                if (isActive) {
//                    println("Fib result: ${fibWithCoroutine(it)}")
//                }
//            }
////        }
//        }
//        println("Code execution time: $time ms")
//    }
//    job.join()
//    println("Inside Main Block before finish")
//}
//
//fun fibWithCoroutine(n: Int): Long {
//    return if (n == 0) 0
//    else if (n == 1) 1
//    else fibWithCoroutine(n-1) + fibWithCoroutine(n-2)
//}

//  Exception will be propagated to next coroutine to wards up If it is handled the way it has to be, I mean not try/catch
//  When coroutine is cancelled, it will throw cancellation exception
// Launch will crash the application if not handled
// Async will not crash the application until await is not called or handled
//suspend fun main() = coroutineScope {
//    val string = async {
//        delay(500L)
//        throw Exception()
//        "Result"
//    }
//    launch {
//        try {
//            string.await()
//        }catch (e: Exception) {
//            println("Exception caught")
//        }
//    }
//}
val handler = CoroutineExceptionHandler { _, throwable ->
    println("Caught exception: $throwable")
}
fun main() {
    runBlocking {
        launch(handler) {
            throw Exception()
        }
    }
}