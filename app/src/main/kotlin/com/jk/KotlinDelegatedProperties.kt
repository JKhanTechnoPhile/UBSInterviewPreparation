package com.jk

import kotlin.properties.Delegates

/*
https://kotlinlang.org/docs/delegated-properties.html
https://www.youtube.com/watch?v=zW8oXDkUxCM
 */
/*
By default, the evaluation of lazy properties is synchronized:
the value is computed only in one thread, but all threads will see the same value
 */
//fun main() {
//    synchronized and runs on one thread but can see the same value by other thread
//    val synchronizedLazyValue: String by lazy {
//        println("Computed")
//        "Javeed Khan H"
//    }
//    println("synchronized : $synchronizedLazyValue")
//    println("synchronized : $synchronizedLazyValue")

 //    If the synchronization of the initialization delegate is not required to allow
//    multiple threads to execute it simultaneously, pass LazyThreadSafetyMode.PUBLICATION as a parameter to lazy()
//    val nonSynchronizedLazyValue: String by lazy(LazyThreadSafetyMode.PUBLICATION) {
//        println("Computed")
//        "Javeed Khan H"
//    }
//    println("non-synchronized : $nonSynchronizedLazyValue")
//    println("non-synchronized : $nonSynchronizedLazyValue")
//}

//fun main() {
//    val user = DelegatedPropertyObservable()
//    user.name = "First"
//    println(user.name)
//    user.name = "Second"
//    println(user.name)

//    val user = DelegatedPropertyVetoable()
//    user.age = 15
//    println(user.age)
//
//    user.age = 35
//    println(user.age)
//}

//class DelegatedPropertyObservable {
//    var name: String by Delegates.observable("<no name>"){
//        property, oldValue, newValue ->
//        println("oldValue: $oldValue")
//        println("newValue: $newValue")
//    }
//}
//
//class DelegatedPropertyVetoable {
//    var age: Int by Delegates.vetoable(12){
//            property, oldValue, newValue ->
//        println("oldValue: $oldValue")
//        println("newValue: $newValue")
//        newValue > 30
//    }
//}

//Storing properties in a map
fun main() {
//    map key should match with class param and it is case sensitive
//    val user = UserMapDelegate(
//        mapOf(
//            "name" to "Javeed Khan H",
//            "age" to 35
//        )
//    )
//    println(user.name)
//    println(user.age)

    val mutableMapUser = UserMutableMapDelegate(
        mutableMapOf(
            "name" to "Javeed Khan H",
            "age" to 35
        )
    )
    println(mutableMapUser.name)
    println(mutableMapUser.age)

    mutableMapUser.name = "Afshiya Khanum"
    mutableMapUser.age = 30

    println(mutableMapUser.name)
    println(mutableMapUser.age)
}


class UserMapDelegate(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}

class UserMutableMapDelegate(val map: MutableMap<String, Any?>) {
    var name: String by map
    var age: Int by map
}

