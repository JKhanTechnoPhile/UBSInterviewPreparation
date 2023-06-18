package com.jk

/*
Purpose of enum is type safe
Each enum constant is an object
 */
fun main() {

//    val waiting = ProtocolState.valueOf("WAITING")
//    println(waiting.signal())

//    No enum constant com.jk.ProtocolState.WAITINGS - IllegalArgumentException
//    val waiting = ProtocolState.valueOf("WAITINGS")

//    val enums = ProtocolState.values()
//    enums.forEach { println(it.signal()) }

//    printAllValues<Direction>()
}

enum class Direction {
    NORTH , SOUTH , EAST , WEST
}

inline fun <reified T: Enum<T>> printAllValues() {
    println(enumValues<T>().joinToString{it.name})
}

enum class COLOR(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF);
}

enum class ProtocolState {

    WAITING {
        override fun signal(): ProtocolState {
            return TALKING
        }
    },
    TALKING {
        override fun signal(): ProtocolState {
            return WAITING
        }
    };

    abstract fun signal(): ProtocolState
}