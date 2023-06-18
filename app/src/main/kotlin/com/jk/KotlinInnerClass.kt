package com.jk

fun main() {
    val innerClass = OuterClass().InnerClass()
    println(innerClass.getName())
}

class OuterClass {
    private val name: String = "Javeed Khan H"

    inner class InnerClass {
        fun getName(): String = name
    }
}
