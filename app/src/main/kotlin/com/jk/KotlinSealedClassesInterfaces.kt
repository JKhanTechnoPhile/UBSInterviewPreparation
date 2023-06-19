package com.jk

//https://www.youtube.com/watch?v=kLJRZpRhX1o&t=2s
//https://www.digitalocean.com/community/tutorials/kotlin-sealed-class
//https://www.youtube.com/watch?v=weDGgH1_wvk ( Not Watched )
/*
1. The subclasses of sealed classes must be declared in the same file in which sealed class itself is declared.
2. The subclasses can be data class , regular class , object class , another sealed class or sealed interface
3. Sealed class ensures type safety by restricting the set of types at compile time only
4. Sealed class is implicitly an abstract class which cannot be instantiated
5. By default, the constructor of sealed class is private and we cannot make it public or protected
 */
fun main() {
    val error: HTTPError = HTTPError.NotFound
    when(error) {
        HTTPError.NotFound -> println("HTTPError.NotFound")
        is HTTPError.Unauthorized -> println("HTTPError.Unauthorized: ${error.reason}")
    }

    val errorEnum: HttpErrorEnum = HttpErrorEnum.NotFound
    when(errorEnum) {
        HttpErrorEnum.NotFound -> println("HttpErrorEnum.NotFound")
        HttpErrorEnum.Unauthorized -> println("HttpErrorEnum.Unauthorized")
    }
}

sealed interface HTTPErrorInterface {
    data class Unauthorized(val reason: String) : HTTPErrorInterface
    object NotFound: HTTPErrorInterface
}


sealed class HTTPError(val code: Int) {
    data class Unauthorized(val reason: String) : HTTPError(401)
//    object Unauthorized: HTTPError(401)
//    {
//        override fun doSomething() {
//            TODO("Not yet implemented")
//        }
//    }

    object NotFound: HTTPError(404)
//    {
//        override fun doSomething() {
//            TODO("Not yet implemented")
//        }
//    }

//    abstract fun doSomething()

    fun doSomething() {

    }
}

enum class HttpErrorEnum(val code: Int) {
    Unauthorized(401),
    NotFound(404);

    fun doSomething() {

    }
}