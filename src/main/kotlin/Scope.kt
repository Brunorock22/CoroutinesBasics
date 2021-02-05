import kotlinx.coroutines.*

suspend fun main(){
    println("Program has initiated")
    runBlocking {
        launch {
            delay(1000L)
            println("Task from runBlocking")
        }
    }

    GlobalScope.launch {
        delay(50L)
        println("Task from GlobalScope")
    }

    coroutineScope {
        launch {
            delay(1500L)
            println("Task from coroutineScope")
        }
    }
    println("Program has finished")


}