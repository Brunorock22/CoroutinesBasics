import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    runBlocking {
        repeat(100000){
            launch { print(".") }
        }
    }
}