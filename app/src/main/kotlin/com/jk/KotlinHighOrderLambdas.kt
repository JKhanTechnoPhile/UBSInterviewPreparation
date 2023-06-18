package com.jk

import kotlin.math.max

//https://kotlinlang.org/docs/lambdas.html
//https://www.studytonight.com/kotlin/kotlin-higher-order-function
/*
Kotlin functions are first-class, which means functions can be stored in variables and data structures.
Kotlin functions can be passed as argument to and return from other higher-order function
 */
//fun main() {
//    val items = listOf(1,2,3,4,5)
//    val value = items.fold(0, {
//        acc: Int, nextElement: Int ->
//        print("acc = $acc, i = $nextElement, ")
//        val result = acc + nextElement
//        println("result = $result")
//        // The last expression in a lambda is considered the return value:
//        result
//    })
//    println("Fold value: $value")

//    To pass function as an argument we use :: operator with function name
//    higherOrderFunction(::sayHello, "Javeed Khan H")

//    val functionName = higherOrderFunction()
//    functionName("Javeed Khan H")

//    higherOrderFunction(
//        { name: String ->
//            println("Inside the lambda function")
//            println("Say hello to $name")
//        },
//        "Javeed Khan H"
//    )
//}

//  Higher-order functions - A higher-order function is a function that takes functions as parameters, or returns a function.
//fun sayHello(name: String) {
//    println("In sayHello() function")
//    println("Say hello to $name")
//}

//fun higherOrderFunction(functionName: (name: String) -> Unit, name: String) {
//    println("In higher order function")
//    println("Calling sayHello() function...")
//    functionName(name)
//}

//fun higherOrderFunction(): (name: String) -> Unit {
//    println("In higher order function")
//    return ::sayHello
//}

//fun higherOrderFunction(): (name: String) -> Unit {
//    println("In higher order function")
//    return { name: String ->
//        println("Inside the lambda function")
//        println("Say hello to $name")
//    }
//}

//  Invoking a function type instance
//val stringPlus: (String , String) -> String = String::plus
//val intPlus: Int.(Int) -> Int = Int::plus
//fun main() {
//    println(stringPlus.invoke("<-","->"))
//    println(stringPlus("<-","->"))
//
//    println(intPlus.invoke(1,2))
//    println(intPlus(1,2))
//    println(2.intPlus(3))
//}

//  Lambda expressions and anonymous functions

//  Lambda expression syntax
val sum: (Int , Int) -> Int = { x: Int , y: Int -> x + y }

//  Passing trailing lambdas
/*
if the last parameter of a function is a function, then a lambda expression passed
 as the corresponding argument can be placed outside the parentheses
 */
val listOfInt = listOf(1,2,3,4,5)
val product = listOfInt.fold(1) { acc , e -> acc * e }

//  Returning a value from a lambda expression
//val resultFromLambda = listOfInt.filter {
//    val shouldFilter = it > 0
//    shouldFilter
//}
val resultFromLambda = listOfInt.filter {
    val shouldFilter = it > 0
    return@filter shouldFilter
}

//  Underscore for unused variables
fun underscore() {
    val mapOfValues = mapOf(
        1 to "Javeed Khan H",
        2 to "Afshiya Khanum",
        3 to "Sidra Konain",
        4 to "Ammar Hassan",
        5 to "Mohammed Bilal Khan"
    )
//    mapOfValues.forEach { (key,value) ->
//        println("$value")
//    }
    mapOfValues.forEach { (_,value) ->
        println("$value")
    }
}

//  Anonymous functions
//fun(x: Int, y: Int): Int {
//    return x + y
//}

//fun(x: Int, y: Int): Int = x + y

//  Closures
fun closureFunction() {
    var sum = 0
    listOfInt.filter { it > 0 }.forEach {
        sum+=it
    }
    println(sum)
}

fun main() {
    closureFunction()
}


