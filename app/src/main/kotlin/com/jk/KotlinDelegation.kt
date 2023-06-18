package com.jk

/*
https://kotlinlang.org/docs/delegation.html
https://www.youtube.com/watch?v=zW8oXDkUxCM
https://www.youtube.com/watch?v=MfJB-JhRAoQ&list=RDCMUCKNTZMRHPLXfqlbdOI7mCkg&start_radio=1&t=70s
 */

fun main() {
    val b = BaseDelegateImpl(123)
    val d = Derived(b)
    d.print()
    d.overrideAndPrint()
}

interface BaseDelegate {
    fun print()
    fun overrideAndPrint()
}

class BaseDelegateImpl(val x: Int) : BaseDelegate {
    override fun print() {
        println("BaseDelegateImpl.print: $x")
    }

    override fun overrideAndPrint() {
        println("BaseDelegateImpl.overrideAndPrint: $x")
    }
}

class Derived(b: BaseDelegate) : BaseDelegate by b {
    override fun overrideAndPrint() {
        println("Derived.partOfDerivedClass")
    }
}

