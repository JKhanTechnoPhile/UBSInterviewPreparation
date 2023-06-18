//https://kotlinlang.org/docs/scope-functions.html
/*
Kotlin Scope Functions:
1. let - it
2. with - this
3. apply - this
4. run - this
5. also - it

raw - this
la - it

apply , also - return object
let , run, with - return Unit or last statement what ever it return
 */
fun main() {
    val person = Person(
        name = "Javeed Khan H",
        age = 35,
        place = "Bangalore, Karnataka, India"
    )

    val letFun = person.let {
        it.name = "let scope function"
        it
    }
    println(person)

    val alsoFun = person.also {
        it.name = "also scope function"
    }
    println(person)

    val runFun = person.run {
       name = "run scope function"
        this
    }
    println(person)

    val withFun = with(person) {
        name = "with scope function"
        this
    }
    println(person)

    val applyFun = person.apply {
        name = "apply scope function"
    }
    println(person)
}

//data class Person(
//    val name: String,
//    val age: Int,
//    val place: String
//)
data class Person(
    var name: String?,
    val age: Int,
    val place: String
)