package com.jk

//https://kotlinlang.org/docs/fun-interfaces.html
/*
Functional Interfaces are also called as Single Abstract Method [SAM]
Interface will have only one abstract function
 */
fun main() {
    val value = 8
    println("Is $value even? - ${isEvenWithLamda.accept(value)}")
    println("Is $value even? - ${isEven.accept(value)}")
}

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

//  Without SAM conversion
val isEven = object : IntPredicate {
    override fun accept(i: Int): Boolean {
        return i % 2 == 0
    }
}

//  With SAM conversion
val isEvenWithLamda = IntPredicate {
    it % 2 == 0
}