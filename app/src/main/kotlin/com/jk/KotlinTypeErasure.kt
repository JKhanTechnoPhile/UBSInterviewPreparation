package com.jk

fun main() {
    processList(listOf(1,2,3,4,5))
    processList(listOf("Javeed Khan H", "Afshiya Khaum"))
}

@JvmName("processListInt")
fun processList(a: List<Int>) {
    a.forEach { println(it) }
}

@JvmName("processListString")
fun processList(a: List<String>) {
    a.forEach { println(it) }
}