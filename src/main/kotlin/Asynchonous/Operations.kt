package Asynchonous

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        transformOperator()
        filterOperator()
        mapOperator()
    }
}

suspend fun transformOperator() {
    (1..10).asFlow()
        .transform {
            emit("Emitting string value $it")
            emit(it)
        }.collect {
            println(it)
        }
}

suspend fun filterOperator() {
    (1..10).asFlow().filter {
        delay(500L)

        it % 2 == 0
    }.collect {
        println(it)
    }
}

suspend fun mapOperator() {
    (1..10).asFlow()
        .map {
            delay(500L)
            "mapping $it"
        }.collect {
            println(it)
        }
}