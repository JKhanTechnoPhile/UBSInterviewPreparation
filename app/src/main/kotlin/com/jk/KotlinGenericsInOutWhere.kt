package com.jk
//  https://www.youtube.com/watch?v=llDmyWi7V0M

//https://www.youtube.com/watch?v=zhxup-lXvsE
//https://www.youtube.com/watch?v=8_mWs9JQNSE
/*
Generic as basically used to perform same operation for different input types
 */
/*
Basic understanding I got but need more deep knowledge on in , out , where, follow below reference
https://kotlinlang.org/docs/generics.html

https://betulnecanli.medium.com/kotlin-generics-in-out-where-terms-with-examples-445dc0bb45d6

https://www.baeldung.com/kotlin/generics

https://blog.logrocket.com/understanding-kotlin-generics/

https://kt.academy/article/kfde-generics

https://www.codingninjas.com/codestudio/library/generics-in-kotlin
 */
//fun main() {
//    val stringConsumer = StringConsumer()
//    stringConsumer.consume("Hello")
//
//    val anyConsumer = AnyConsumer()
//    anyConsumer.consume("Hello")
//    anyConsumer.consume(123)

//    val stringProducer = StringProducer()
//    println(stringProducer.produce()) // prints "Hello"
//
//    val anyProducer: Producer<Any> = AnyProducer()
//    println(anyProducer.produce()) // prints "Hello"
//}

//interface ReadOnly {
//    fun read(): Any
//}
//
//class ReadWrite<in T>(private val value: T) : ReadOnly {
//    override fun read(): Any {
//        return value
//    }
//}

//interface Consumer<in T> {
//    fun consume(item: T)
//}
//
//class StringConsumer : Consumer<String> {
//    override fun consume(item: String) {
//        println("Consuming string: $item")
//    }
//}
//
//class AnyConsumer : Consumer<Any> {
//    override fun consume(item: Any) {
//        println("Consuming any type: $item")
//    }
//}

//interface WriteOnly {
//    fun write(value: Any)
//}
//
//class ReadWrite<out T>(private var value: T) : WriteOnly {
//    // 'out' keyword allows to use T as an output only
//    // so, the following line will give a compile error
//    // fun read(): T = value
//
//    override fun write(value: Any) {
//         this.value = value
//    }
//}

//interface Producer<out T> {
//    fun produce(): T
//}
//
//class StringProducer : Producer<String> {
//    override fun produce(): String = "Hello"
//}
//
//class AnyProducer : Producer<Any> {
//    override fun produce(): Any = "Hello"
//}

//  https://www.youtube.com/watch?v=yHz-PMooHWg&list=PLrJS8IW7z9HG3SUnHjA81hM1xzJdFT2nv&index=36
fun main() {
//    val integerList: List<Int> = listOf(1,2)
//    val numberList: List<Number> = integerList // No error - Read-Only list

//    Int is a sub type of Number but MutableList<Int> is not sub type of MutableList<Number>
//    val integerList: MutableList<Int> = mutableListOf(1,2)
//    val numberList: MutableList<Number> = integerList // Error: Type mismatch - MutableList

//    Covariance - out ( Producers )
    val admins: List<Administrator> = listOf()
    val normalUsers: List<NormalUser> = listOf()
//    val userList: List<UserGenerics> = admins   // Works
    val userList: List<UserGenerics> = normalUsers  // Works

//    Contravariance - in ( Consumers )
//    val userComparator : Comparable<UserGenerics> = adminComparator // Error: Type mismatch.
    val userComparator : Comparable<Administrator> = userComparator
}

val adminComparator: Comparable<Administrator> =
    object : Comparable<Administrator> {
        override fun compareTo(other: Administrator): Int {
            return 1
        }
    }

val userComparator: Comparable<UserGenerics> =
    object : Comparable<UserGenerics> {
        override fun compareTo(other: UserGenerics): Int {
            return 1
        }
    }

//    Covariance - out ( Producers )
interface Producer<out T> {
    fun produce(): T
}


//    Contravariance - out ( Producers )
interface Consumer<in T> {
    fun consume(item: T)
}

open class UserGenerics(val userType: Int)
class Administrator(val auth: String) : UserGenerics(1)
class NormalUser(val pass: String) : UserGenerics(2)