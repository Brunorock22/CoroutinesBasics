package Asynchonous

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        catch()
//        tryCatche()
    }
}

suspend fun catch() {
    (1..3).asFlow().onEach { check(it != 2) }
        .onCompletion { e ->
            if (e != null) {
                println("Flow completed successfully")
            }
        }
        .catch { e -> println("Caugth exception $e") }
        .collect { println(it) }
}

suspend fun tryCatche() {
    try {
        (1..3).asFlow().onEach { check(it != 2) }
            .collect {
                println(it)
            }

    } catch (e: Exception) {
        println("Caught exeption ${e.message}")
    }
}

