package com.jk

import android.content.Context
import android.graphics.drawable.shapes.Shape
import android.util.AttributeSet
import android.view.View

//https://kotlinlang.org/docs/inheritance.html#overriding-rules

fun main() {
//    val circle = Circle()
//    circle.draw()

//    val rectangles = Rectangles()
//    rectangles.draw()
//
//    val testRectangles = Rectangles.TestRectangles()
//    testRectangles.draw()

//    val derivedClass = DerivedClass("javeed", "Khan")

    val squareOverridingRules = SquareOverridingRules()
    squareOverridingRules.draw()
}

class Dummy {
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return super.toString()
    }
}

//open class Base(p: Int) {
//
//}
//
//class Derived(p: Int) : Base(p) {
//
//}

// No primary constructor so need to delegate base class with super over secondary constructor's
//class MyView: View {
//
//    constructor(ctx: Context): super(ctx)
//
//    constructor(ctx: Context, attrs: AttributeSet): super(ctx, attrs)
//}

// Has primary constructor so no need to delegate base class with super over secondary constructor's
//class MyView(ctx: Context): View(ctx) {
//
//}

// Has primary constructor so no need to delegate base class with super over secondary constructor's
//class MyView(ctx: Context, attrs: AttributeSet): View(ctx, attrs) {
//
//}

//open class Shape {
//    open fun draw() {
//        println("Shape.draw")
//    }
//    fun fill() {
//
//    }
//}
//
//class Circle() : Shape() {
//    override fun draw() {
//        println("Circle.draw")
//    }
//}

//open class Rectangles(): Shape() {
//    override fun draw() {
//        super.draw()
//        println("Rectangles.draw")
//    }

//    final override fun draw() {
//        super.draw()
//        println("Rectangles.draw")
//    }
//}

//class TestRectangles(): Rectangles() {
//    override fun draw() {
//        super.draw()
//        println("TestRectangles.draw")
//    }
//    Declare final on override fun to avoid implementation
//}

//open class ShapeProp {
//    open val vertexCount: Int = 0
//}

//class RectangleProp: ShapeProp() {
//    override val vertexCount: Int = 4

//    override val vertexCount: Int
//        get() = 4//super.vertexCount
//    override var vertexCount: Int = 4 // val can be override has var but not vice versa
//}
//
//interface ShapeInterface {
//    val vertexCount: Int
//}
//
//class RectangleInterface(override val vertexCount: Int = 4) : ShapeInterface {
//
//}
//
//class PolygonInterface : ShapeInterface {
//    override var vertexCount: Int = 0
//
//}

//open class Base(val name: String) {
//    init {
//        println("Initializing a base class")
//    }
//
//    open val size: Int = name.length.also {
//        println("Initializing size in the base class: $it")
//    }
//}
//
//class DerivedClass(name: String,
//val lastName: String) : Base(
//    name.replaceFirstChar { it.uppercase() }.also { println("Argument for the base class: $it") }
//) {
//    init { println("Initializing a derived class") }
//
//    override val size: Int =
//        (super.size + lastName.length).also { println("Initializing size in the derived class: $it") }
//}

open class RectangleOverridingRules {
    open fun draw() {
        println("RectangleOverridingRules.draw()")
    }
}

interface PolygonOverridingRules {
    fun draw() {
        println("PolygonOverridingRules.draw()")
    }
}

class SquareOverridingRules(): RectangleOverridingRules() , PolygonOverridingRules {
    override fun draw() {

        super<RectangleOverridingRules>.draw() // Optional
        super<PolygonOverridingRules>.draw() // Optional
        println("SquareOverridingRules.draw()")
    }
}