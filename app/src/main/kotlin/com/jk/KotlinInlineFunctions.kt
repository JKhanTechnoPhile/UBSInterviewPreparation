package com.jk

//https://kotlinlang.org/docs/inline-functions.html
//https://www.youtube.com/watch?v=RJd_7HMUNsM&list=PLrJS8IW7z9HG3SUnHjA81hM1xzJdFT2nv&index=51
fun main() {
    println("Before")
    callAction{
        println("Something")
        println("Something else")
    }

//    callAction({
//        println("Something")
//        println("Something else")
//    }, { println("Second action") })

//    callAction({
//        println("Something")
//        println("Something else")
//        return // Called non-local return which terminates execution of main function, only if caller function is marked as inline
//    }, {
//        println("Second action")
//        return
//    })

    println("After")
}

//inline fun callAction(someAction: () -> Unit) {
//    someAction()
//}

//  Can't inline 'someAction' here: it may contain non-local returns. Add 'crossinline' modifier to parameter declaration 'someAction'
//inline fun callAction(someAction: () -> Unit) {
//    call { someAction() }
//}
inline fun callAction(crossinline someAction: () -> Unit) {
    call { someAction() }
}

fun call(f: () -> Unit) {
    f()
}

//inline fun callAction(someAction: () -> Unit, someOtherAction: () -> Unit) {
//    someAction()
//    someOtherAction()
//}

//inline fun callAction(someAction: () -> Unit, noinline someOtherAction: () -> Unit) {
//    someAction()
//    someOtherAction()
//}