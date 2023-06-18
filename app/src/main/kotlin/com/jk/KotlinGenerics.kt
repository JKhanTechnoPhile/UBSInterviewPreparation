package com.jk
//  https://www.youtube.com/watch?v=llDmyWi7V0M

//https://www.youtube.com/watch?v=zhxup-lXvsE
//https://www.youtube.com/watch?v=8_mWs9JQNSE
/*
Generic as basically used to perform same operation for different input types
 */
fun main() {
    val objInt = GenericContainer<Int>(data = 100)
    val objString = GenericContainer<String>(data = "Hello Generics")
    addVarArg(1,2,3,4,5,6)
}

fun addVarArg(vararg values: Int) {
    var sum = 0
    for (i in values) {
        sum+=i
    }
    println(sum)
}

class GenericContainer<T>(var data: T) {
    fun setValue(value: T) {
        data = value
    }

    fun getValue(): T {
        return data
    }
}

class IntContainer(var data: Int) {
    fun setValue(value: Int) {
        data = value
    }

    fun getValue(): Int {
        return data
    }
}

class StringContainer(var data: String) {
    fun setValue(value: String) {
        data = value
    }

    fun getValue(): String {
        return data
    }
}