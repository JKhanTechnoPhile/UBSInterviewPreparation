package com.jk

//https://kotlinlang.org/docs/inline-classes.html#inheritance
/*
Inline class properties cannot have backing fields
no lateinit or delegate properties
It is forbidden for inline classes to participate in a class hierarchy. This means that inline classes cannot extend other classes and are always final.
 */
fun main() {
    val login = Login(
        userName = UserName("javeedkhanh1987@gmail.com"),
        password = Password("@fshi4sJaan@2013")
    )
    login.login()

//    val login = Login("@fshi4sJaan@2013" , "javeedkhanh1987@gmail.com")
//    login.login()
}

@JvmInline
value class Password(private val s: String) : PrintValue {

    init {
        require(s.length == 16) {
            println("Password length not satisfied")
        }
    }

    fun getPassword(): String = s

    override fun printString(): String {
        return s
    }
}

@JvmInline
value class UserName(private val s: String) : PrintValue {

    fun getUserName(): String = s

    override fun printString(): String {
        return s
    }
}

interface PrintValue {
    fun printString(): String
}

//class Login(private val userName: String, private val password: String) {
//    fun login() {
//        if (
//            !userName.isNullOrEmpty() && userName == "javeedkhanh1987@gmail.com" &&
//            !password.isNullOrEmpty() && password == "@fshi4sJaan@2013"
//        ) {
//            println("Login success")
//        } else {
//            println("Login failed")
//        }
//    }
//}

class Login(private val userName: UserName, private val password: Password) {
    fun login() {
        if (
            !userName.getUserName().isNullOrEmpty() && userName.getUserName() == "javeedkhanh1987@gmail.com" &&
            !password.getPassword().isNullOrEmpty() && password.getPassword() == "@fshi4sJaan@2013"
        ) {
            println("Login success")
        }
    }
}