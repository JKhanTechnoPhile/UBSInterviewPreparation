package com.jk

//https://kotlinlang.org/docs/operator-overloading.html
fun main() {
    val a = 100
    val b = 100
    a.unaryPlus()
    a.unaryMinus()
    true.not()

    a.inc()
    a.dec()

    a.plus(b)
    a.minus(b)
    a.times(b)
    a.div(b)
    a.rem(b)
    a.rangeTo(b)

    val listA = emptyList<String>()
    val listB = emptyList<String>()
//    listB.contains(listA)
}