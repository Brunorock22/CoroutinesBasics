package Channels

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val producer = produceNewNumbers()
        repeat(5){
            launchProcessor(it, producer)
        }
        delay(1000L)
        producer.cancel()
    }
}

fun CoroutineScope.produceNewNumbers() = produce{
    var x = 1

    while(true){
        send(x++)
        kotlinx.coroutines.delay(100L)
    }
}

fun CoroutineScope.launchProcessor(id: Int, channel: ReceiveChannel<Int>) =
    launch {
        for(message in  channel)
            println("Processors $id received $message")
    }