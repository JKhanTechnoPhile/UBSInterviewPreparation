package com.jk

/*
There is one important semantic difference between object expressions and object declarations:
Object expressions are executed (and initialized) immediately, where they are used.
Object declarations are initialized lazily, when accessed for the first time.
A companion object is initialized when the corresponding class is loaded (resolved) that matches the semantics of a Java static initializer.
 */

//fun main() {
//    println(user)
//}

//  Object expressions - Creating anonymous objects from scratch
val user = object {
    val firstName = "Javeed"
    val lastName = "Khan H"
    val age = 35
    val dateOfBirth = "17-12-1987"

    override fun toString(): String {
        return """
            firstName: $firstName
            lastName: $lastName
            age: $age
            dateOfBirth: $dateOfBirth
        """.trimIndent()
    }
}

interface MouseAdapter {
    fun mouseClicked(e: MouseEvent)
    fun mouseEntered(e: MouseEvent)
}

interface MouseEvent

val inheritSuperInterface = object : MouseAdapter {
    override fun mouseClicked(e: MouseEvent) {
        TODO("Not yet implemented")
    }

    override fun mouseEntered(e: MouseEvent) {
        TODO("Not yet implemented")
    }
}

open class A(x: Int) {
    open val y: Int = x
}

interface B {}

val ab: A = object : A(100), B {

    override val y: Int
        get() = 123
}

class C {
    private fun getObject() = object {
        val x: String = "X"
    }

    fun printX() {
        println(getObject().x)
    }
}

//  Object declarations - Singleton pattern
/*
The initialization of an object declaration is thread-safe and done on first access.
 */
fun main() {
    DataProviderManager.registerDataProvider()
    DataProviderManager.allRegisteredDataProvider
    DefaultAdapter.mouseClicked(object : MouseEvent {

    })
    DefaultAdapter.mouseEntered(object : MouseEvent {

    })
}

object DataProviderManager {
    fun registerDataProvider() {

    }

    val allRegisteredDataProvider: Any
        get() = Any()
}

object DefaultAdapter : MouseAdapter {
    override fun mouseClicked(e: MouseEvent) {
        TODO("Not yet implemented")
    }

    override fun mouseEntered(e: MouseEvent) {
        TODO("Not yet implemented")
    }
}

//data object MyDataObject {
//
//}

class MyClass {
//    companion object Factory {
//        fun create(): MyClass = MyClass()
//    }
    companion object {
        fun create(): MyClass = MyClass()
    }
}

//val instance = MyClass.create()

val instance = MyClass.Companion

interface Factory<T> {
    fun create(): T
}

class MyClassFactory {
    companion object : Factory<MyClassFactory> {
        override fun create(): MyClassFactory = MyClassFactory()
    }
}

val f: Factory<MyClassFactory> = MyClassFactory

