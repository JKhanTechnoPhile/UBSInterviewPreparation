package com.jk

//https://kotlinlang.org/docs/data-classes.html
/*
1. The primary constructor needs to have at least one parameter.
2. All primary constructor parameters need to be marked as val or var.
3. Data classes cannot be abstract, open, sealed, or inner.
 */

fun main() {
//    val user = User("Javeed Khan H", 35)
//    val duplicateUser = User("Javeed Khan H", 35)
//    val copyUser = user.copy()
//    println("hashCode: ${user.hashCode()}")
//    println("toString: ${user.toString()}")
//    println("equals: ${user.equals(duplicateUser)}")
//    println("copy: $copyUser")
//    println("component1: ${copyUser.component1()}")
//    println("component2: ${copyUser.component2()}")

//    user.age = 30 // Allowed due to var
//    user.name = "Afshiya" // Not allowed due to val

//    val user = User()
//    user.name = "Javeed Khan H"
//    user.age = 35
//    println("user: $user")

//    val user = User()
//    println("user: $user")

//    Properties declared in the class body
//    val user = User("Javeed Khan H")
//    user.age = 35
//
//    val duplicateUser = User("Javeed Khan H")
//    duplicateUser.age = 30
//
//    val copyUser = user.copy()
//    println("toString: ${user.toString()}")
//    println("equals: ${user.equals(duplicateUser)}")
//    println("copy: $copyUser")
//    println("component1: ${copyUser.component1()}")
//    println("component2: ${copyUser.component2()}") // Not consider due to undeclared in primary constructor

//    Copying -
//    val user = User("Javeed Khan H", 35)
//    println("user: $user")
//    copy which is required and leave as is for others
//    val copyingUser = user.copy(
//        name = "Afshiya Khanum"
//    )
//    println("copyingUser: $copyingUser")

//    Data classes and destructuring declarations
    val user = User("Javeed Khan H", 35)
    val (name, age) = user
    println("destructuring: $name $age")
}

//data class User(val name: String, val age: Int)
//data class User(val name: String, val age: Int) {
//
//    override fun toString(): String {
//        return super.toString()
//    }
//
//    override fun hashCode(): Int {
//        return super.hashCode()
//    }
//
//    override fun equals(other: Any?): Boolean {
//        return super.equals(other)
//    }
////    copy - not allowed
////    component - not allowed
//}

data class User(val name: String, var age: Int)
//data class User(val name: String? = null, val age: Int? = null)
//data class User(var name: String? = null, var age: Int? = null)
//data class User(val name: String = "", val age: Int = 0)

//  Properties declared in the class body
/*
The compiler only uses the properties defined inside the primary constructor for the automatically generated functions. To exclude a property from the generated implementations, declare it inside the class body:
 */
//data class User(val name: String) {
//    var age: Int = 0
//}
