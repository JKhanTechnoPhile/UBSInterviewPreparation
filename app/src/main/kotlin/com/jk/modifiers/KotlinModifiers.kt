package com.jk.modifiers

fun main() {
    val objA = A()
    val objB = B()

    objA.pub
    objA.inter
//    objA.protect // Not accessible

    objB.pub
    objB.inter
//    objB.protect // Not accessible
}

open class A {
    public var pub = 10
    private var priv = 20
    internal var inter = 30
    protected var protect = 40
}

class B : A() {
    fun test() {
        println(pub) // Accessible every where
//        println(priv) // Only accessible in same file
        println(inter) // Only accessible in same module
        println(protect) // Only accessible in sub class
    }
}