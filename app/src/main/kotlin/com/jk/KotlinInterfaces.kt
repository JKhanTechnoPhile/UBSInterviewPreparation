package com.jk

fun main() {

}

interface MyInterface {
    val prop: Int

    val propertyWithImplementation: String
        get() = "Foo"

    fun bar()
    fun foo() {
        // Optional body
    }
}

class Child : MyInterface {
    override val prop: Int = 29

//    override val prop: Int
//        get() = 29
    override fun bar() {
        TODO("Not yet implemented")
    }
}

interface Named {
    val name: String
}

interface PersonInterface : Named {
    val firstName: String
    val secondName: String
    override val name: String
        get() = "$firstName $secondName"
}

data class Employee (
    override val firstName: String,
    override val secondName: String,
    val position: MyInterface
) : PersonInterface