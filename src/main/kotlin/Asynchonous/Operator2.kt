package Asynchonous

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        flowOnOperator()
//        reduceOperator()
//        takeOperator()
    }
}

suspend fun flowOnOperator(){
    (1..10).asFlow()
        .flowOn(Dispatchers.IO)
        .collect {
            println(it)
        }
}

suspend fun reduceOperator() {
    val size = 4
    val factorial = (1..size).asFlow().reduce { accumulator, value ->
        accumulator * value
    }
    println("Factorial of $size is $factorial")
}

//Just limete out our processing to a certain number of values
suspend fun takeOperator() {
    (1..10).asFlow()
        .take(2)
        .collect {
            println(it)
        }
}