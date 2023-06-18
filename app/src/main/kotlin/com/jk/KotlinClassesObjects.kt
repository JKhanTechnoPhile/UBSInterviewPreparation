package com.jk

fun main() {
//    println(Empty().toString())
//    val person = Person(
//        name = "Javeed Khan H",
//        age = Integer(35),
//        location = "Bangalore",
//    )
//    person.isEmployed = true
//    println(person)

//    val person = Person(
//        name = "Javeed Khan H",
//        age = Integer(35),
//        location = "Bangalore",
//        employeeId = "E870049"
//    )
//    person.isEmployed = true
//    println(person)

    val rectangle = Rectangle()
    rectangle.draw()
}

class Empty {
    override fun toString(): String {
        return "Empty Class"
    }
}

//class Person constructor(val name: String, val age: Int, val location: String) {
//class Person constructor(name: String, age: Int, location: String) {
//
//    private val name = name
//    private val age = age
//    private val location = location
//class Person constructor(name: String, age: Integer, location: String, var isEmployed: Boolean = false) {
//class Person public constructor(name: String, age: Integer, location: String, var isEmployed: Boolean = false) {
class Person private constructor(name: String, age: Integer, location: String, var isEmployed: Boolean = false) {

    private lateinit var _name: String
    private lateinit var _age: Integer
    private lateinit var _location: String
    private lateinit var _employeeId: String

    init {
        _name = name
        _age = age
        _location = location
        println("First Init block")
    }

    init {
        println("Secondary Init block")
    }

    constructor(name: String, age: Integer, location: String, isEmployed: Boolean = false, employeeId: String) : this(name, age, location, isEmployed) {
        _employeeId = employeeId
    }

    override fun toString(): String {
        return """
            name: $_name
            age: $_age
            location: $_location
            Employeed: $isEmployed
        """.trimIndent()
    }
}

//abstract class PolygonAbstract {
//    abstract fun draw()
//}

//class Rectangle : PolygonAbstract() {
//    override fun draw() {
//        println(this::class.java.name)
//    }
//}

open class Polygon {
    open fun draw() {
        println("Polygon.draw()")
    }
}

abstract class WildShape: Polygon() {
    abstract override fun draw()
}

class Rectangle : WildShape() {
    override fun draw() {
       println("Rectangle.draw()")
    }
}