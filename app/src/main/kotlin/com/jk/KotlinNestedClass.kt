package com.jk

fun main() {
    val nestedClass = OuterTopClass.InnerClass()
    println(nestedClass.getName())
}

class OuterTopClass {
    private val name: String = "Javeed Khan H"

    class InnerClass {
        fun getName(): String = "Afshiya Khanum"
    }
    interface InnerInterface
}

interface OuterTopInterface {
    class InnerClass
    interface InnerInterface
}
