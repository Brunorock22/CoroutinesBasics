import kotlinx.coroutines.*
import java.lang.ArithmeticException
import java.lang.IndexOutOfBoundsException

fun main(){
    runBlocking {
        val myHandler = CoroutineExceptionHandler{ coroutineContext, throwable ->
            println("Exception handled: ${throwable.localizedMessage}")

        }
        val job = GlobalScope.launch(myHandler) {
            println("Throwing exception from job")
            throw IndexOutOfBoundsException()
        }
        job.join()

        val defered = GlobalScope.async {
            println("Throwing execption from async")
            throw ArithmeticException("Exception from async")
        }
        try {

        defered.await()
        }catch (e: ArithmeticException){
            println("ArithmeticException")
        }
    }
}