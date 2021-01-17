import kotlinx.coroutines.*

fun main() {
    runBlocking {
//        launch(Dispatchers.Main) {
//            println("Main dispatcher, Thread: ${Thread.currentThread().name}")
//        }

        launch(Dispatchers.Unconfined) {
            println("Unconfined dispatcher1, Thread: ${Thread.currentThread().name}")
            delay(100L)
            println("Unconfined dispatcher2, Thread: ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Default) {
            println("Defalt dispatcher, Thread: ${Thread.currentThread().name}")
        }

        launch(newSingleThreadContext("MyThread")){
            println("newSingleThread dispatcher, Thread: ${Thread.currentThread().name}")
        }
    }
}