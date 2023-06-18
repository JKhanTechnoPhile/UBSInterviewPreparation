package com.jk

import kotlin.reflect.KClass

fun main() {
//    makeSomething("String", String::class)
//    makeSomething(5, Int::class)
//    makeSomething(6.2f, Float::class)

    makeSomething("String")
    makeSomething(5)
    makeSomething(6.2f)

    listOf<Int>().filterSomething<Int>()
}

//fun <T> makeSomething(value: T) {
//    println("type is $value")
////    Cannot use 'T' as reified type parameter. Use a class instead.
////    println("type is ${T::class.simpleName}")
//}

//fun <T : Any> makeSomething(value: T, type: KClass<T>) {
//    println("type is $value")
//    println("type is $type")
//}

inline fun <reified T : Any> makeSomething(value: T) {
    println("value is $value")
    println("type is ${T::class.java.simpleName}")
}

inline fun <reified T> List<Any>.filterSomething(): List<T> {
    return this.filter { it is T }.map { it as T }
}