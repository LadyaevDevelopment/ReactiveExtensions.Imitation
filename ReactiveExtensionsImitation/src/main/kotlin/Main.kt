import com.rx.Consumer
import com.rx.Flow
import com.rx.cold.ColdFlow

fun main() {
    val dataFlow: Flow<Int> = ColdFlow.create {
        onNext(67)
        onComplete()
    }
    val dataConsumer1 = object : Consumer<Int> {
        override fun onNext(data: Int) {
            println("onNext1: $data")
        }
        override fun onError(error: Throwable) {
            println("error1: $error")
        }
        override fun onComplete() {
            println("onComplete1")
        }
    }
    val dataConsumer2 = object : Consumer<Int> {
        override fun onNext(data: Int) {
            println("onNext2: $data")
        }
        override fun onError(error: Throwable) {
            println("error2: $error")
        }
        override fun onComplete() {
            println("onComplete2")
        }
    }
    dataFlow.consume(dataConsumer1)
    Thread.sleep(1000)
    dataFlow.consume(dataConsumer2)
}