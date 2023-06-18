package com.jk

import com.jk.modifiers.getLongestString

fun main() {
//    Extension Function
//    val list = mutableListOf(1,2,3)
//    println("List Before Swap: $list")
//    list.swap(0, 2)
//    println("List after Swap: $list")

//    Example().printFunctionType()
//    Example().printFunctionType(1)

//    val nullableReceiver = "Hello Nullable Receiver"
//    val nullableReceiver: String? = null
//    println("nullableReceiver: ${nullableReceiver.extensionToString()}")

//    val nullableReceiverDataClass = NullableReceiver("Javeed", "Khan")
//    val nullableReceiverDataClass:NullableReceiver? = null
//    println("nullableReceiverDataClass: ${nullableReceiverDataClass.extensionToString()}")

//    Extension Properties
//    val list = listOf(1,2,3,4,5)
//    println("Extension properties: ${list.lastIndex}")
//
//    val house = HouseExtension()
//    println("HouseExtension: ${house.number}")

//    Companion object extensions
//    CompanionObjectExtensions().printCompanion()

//    Scope of extensions
//    val list = listOf("red", "green", "blue")
//    list.getLongestString()

//    Declaring extensions as members
//    Connection(Host("kotl.in"), 443).connect()

    BaseCaller().call(BaseExtension())   // "Base extension function in BaseCaller"
    DerivedCaller().call(BaseExtension())  // "Base extension function in DerivedCaller" - dispatch receiver is resolved virtually
    DerivedCaller().call(DerivedExtension())  // "Base extension function in DerivedCaller" - extension receiver is resolved statically
}

open class BaseExtension {}

class DerivedExtension : BaseExtension() {}

open class BaseCaller {
    open fun BaseExtension.printFunctionInfo() {
        println("BaseExtension extension function in BaseCaller")
    }

    open fun DerivedExtension.printFunctionInfo() {
        println("DerivedExtension extension function in BaseCaller")
    }

    fun call(b: BaseExtension) {
        b.printFunctionInfo()   // call the extension function
    }
}

class DerivedCaller : BaseCaller() {
    override fun BaseExtension.printFunctionInfo() {
        println("Base extension function in DerivedCaller")
    }

    override fun DerivedExtension.printFunctionInfo() {
        println("Derived extension function in DerivedCaller")
    }
}

class Host(private val hostName: String) {
    fun printHostName() {
        print(hostName)
    }
}

class Connection(val host: Host, val port: Int) {
    fun printPort() { print(port) }

    fun Host.printConnectionString() {
        printHostName()
        print(":")
        printPort()
    }

    fun connect() {
        host.printConnectionString()
    }
}

class CompanionObjectExtensions {
    companion object {}
}

fun CompanionObjectExtensions.printCompanion() { println("companion") }

val <T> List<T>.lastIndex: Int
    get() = size - 1

class HouseExtension

//val HouseExtension.number: String
//    get() = "#16/12, 1st Main, 7th Cross, B'lore-560029"

//  Extension property cannot be initialized because it has no backing field
//val HouseExtension.number = "#16/12, 1st Main, 7th Cross, B'lore-560029"
//var HouseExtension.number = "#16/12, 1st Main, 7th Cross, B'lore-560029"
//    get() {
//        return field
//    }
//    set(value) {
//        field = value
//    }


//fun MutableList<Int>.swap(index1: Int, index2: Int) {
//    val tmp = this[index1]
//    this[index1] = this[index2]
//    this[index2] = tmp
//}

//  Generic
fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

fun <T> Array<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

fun <T> ArrayList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

class Example {
    fun printFunctionType() { println("Class function") }
}

// Prints class function & this can be achieved by same name and different signature
fun Example.printFunctionType() { println("Extension function") }

fun Example.printFunctionType(i: Int) { println("Extension function: $i") }

//  Nullable receiver
fun Any?.extensionToString(): String {
    if (this == null) return "null"

    return toString()
}

data class NullableReceiver(
    val firstName: String,
    val lastName: String
)