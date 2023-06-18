import com.jk.Message
import com.jk.printMessage
import kotlin.NumberFormatException

//https://kotlinlang.org/docs/basic-types.html
/*
Every thing is an object in kotlin, you can call member functions & properties.
1. Numbers
2. Booleans
3. Characters
4. Strings
5. Arrays
 */
fun main() {
//    Signed Integer Types - Number
    val sByte = Byte // Size - 8 bits
    val sShort = Short // Size - 16 bits
    val sInt = Int // Size - 32 bits
    val sLong = Long // Size - 64 bits

//    Unsigned Integer Types - Number
    val usByte = UByte // Size - 8 bits
    val usShort = UShort // Size - 16 bits
    val usInt = UInt // Size - 32 bits
    val usLong = ULong // Size - 64 bits

//    Floating-point Types - Number
    val float = Float // Size - 32
    val double = Double // Size - 64

//    val aChar: Char = '9'
//    println(aChar.digitToInt())

//    val str = "Javeed Khan H"
//    for ((index, char) in str.withIndex()) {
//        println("Char index: $index) $char")
//    }

    val array = Array(6) { index ->
        when(index) {
            0 -> "Javeed Khan H"
            1 -> "Afshiya Khanum"
            2 -> "Sidra Konain"
            3 -> "Ammar Hassan"
            4 -> "Mohammed Bilal Khan"
            else -> null
        }
    }
//    for (item in array) {
//        println(item)
//    }
//    val arrayIterator = array.iterator()
//    while (arrayIterator.hasNext()) {
//        println(arrayIterator.next())
//    }
//    array.forEach { println(it) }
//    array[5] = "Nothing"
//    println(array[5])

//    Primitive type arrays
    val intArray = intArrayOf(1,2,3,4,5)
    val shortArray = shortArrayOf(1,2,3,4,5)
    val longArray = longArrayOf()

//    val string = 35//"Javeed Khan H"
//    smartCast(string)

//    forLabel@ for (i in 1..100) {
//        if (i % 2 == 0) break@forLabel
//        println(i)
//    }

//    val tryIsAnExpression: Int? = try {
//        null
//    } catch (e: NumberFormatException) {
//        null
//    }
//    val v = tryIsAnExpression ?: throw NumberFormatException("Not a number")
//    println(v)

    printMessage("Hello")
    val message = Message()
}

fun smartCast(value: Any) {
//    if (value is String) {
//        println(value.length)
//    }
//    println((value as String).length)
    println((value as? String)?.length)
}