package Asynchonous

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        sendNumbers().collect {
            println("Received $it")
        }
    }
}

fun sendNumbers() = listOf(1, 2, 3).asFlow()

fun sendLetters() = flowOf("One", "Two", "Three")