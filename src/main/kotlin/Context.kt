import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        launch(CoroutineName("Bruno Coroutine")) {
            println("This is run from ${this.coroutineContext.get(CoroutineName.Key)}")
        }
    }
}