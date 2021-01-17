import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {

    runBlocking {
        val firstDeferred = async { getFirstValue() }
        println("Doing some processing here")
        val secondDeferred = async { getSecondValue() }
        println("Wating for values")

        val firstValue = firstDeferred.await()
        val secondValue = secondDeferred.await()
        print("the total is ${firstValue + secondValue}")
    }

}

suspend fun getFirstValue(): Int {
    delay(5000L)
    val value = Random.nextInt(100)
    println("Returning first value $value")
    return value
}

suspend fun getSecondValue(): Int {
    delay(5000L)
    val value = Random.nextInt(2154)
    println("Returning second value $value")
    return value
}