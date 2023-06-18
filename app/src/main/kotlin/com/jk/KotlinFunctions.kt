package com.jk

import java.math.BigInteger

//fun main() {
//    val a = arrayOf(1,2,3,4,5)
//    println(a)
//    val list = asList(a)
//    println(list)
//}
//
//fun <T> asList(vararg ts: T): List<T> {
//    val result = ArrayList<T>()
//    for (t in ts) {
//        result.add(t)
//    }
//    return result
//}

//  Infix notation
//fun main() {
//    println("Normal Extension Function: ${10.add(89)}")
//    println("Infix Extension Function: ${10 add 89}")
//    Examples - shl , shr , map( "a" to "b" ) - to
//}

//fun Int.add(other: Int) = this + other
//infix fun Int.add(other: Int) = this + other

//  'infix' modifier is inapplicable on this function: must have a single value parameter
//infix fun Int.addAndMultiply(additionVal: Int, multiplyVal: Int) = this + additionVal

//  Function scope
fun main() {
//    computeList(listOf(1,2,3,4,5))
//    MemberFunctionClass().memberFunction()
//    singletonList(arrayListOf(1,2,3,4))
//    println(fib(10, ""))
//    fibUsingFor()
    fibUsingWhile()
}
//  1.Local Functions
fun computeList(list: List<Int>) {

//    fun summation(list: List<Int>): Int {
//        return list.reduce { result , nextValue ->
//            result + nextValue
//        }
//    }
    fun summation(list: List<Int>): Int  = list.sum()

    println("Summation: ${summation(list)}")
}

//  2.Member Functions
class MemberFunctionClass {
    fun memberFunction() {
        println("MemberFunctionClass.memberFunction()")
    }
}

//  3.Generic Functions
fun <T> singletonList(item: T): List<T> {
    return emptyList()
}

//  Tail recursive functions

val cache = mutableMapOf(
    0 to BigInteger.ZERO,
    1 to BigInteger.ONE
)

fun fib(n: Int, chain: String): BigInteger {
    val chain = "$chain $n"
    println(chain)
    return cache.getOrPut(n) {
        val a = fib(n - 2, chain)
        val b = fib(n - 1, chain)
        println(chain)
        a + b
    }
}

//https://www.programiz.com/kotlin-programming/examples/fibonacci-series
fun fibUsingFor() {
    val n = 10
    var t1 = 0
    var t2 = 1

    print("First $n terms: ")

    for (i in 1..n) {
        print("$t1 + ")

        val sum = t1 + t2
        t1 = t2
        t2 = sum
    }
}

fun fibUsingWhile() {
    val n = 100
    var t1 = 0
    var t2 = 1

    print("Upto $n: ")

    while (t1 <= n) {
        print("$t1 + ")

        val sum = t1 + t2
        t1 = t2
        t2 = sum
    }
}

//fun fib(n: Int, chain: String): BigInteger {
//    val chain = "$chain $n"
//    println(chain)
//    return when(n) {
//        0 -> BigInteger.ZERO
//        1 -> BigInteger.ONE
//        else -> {
//            val a = fib(n - 2, chain)
//            val b = fib(n - 1, chain)
//            println(chain)
//            a + b
//        }
//    }
//}