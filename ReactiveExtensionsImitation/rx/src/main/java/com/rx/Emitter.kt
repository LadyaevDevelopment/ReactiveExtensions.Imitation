package com.rx

class Emitter<T>(
    private val sourceFactory: Consumer<T>.() -> Unit,
) : Consumer<T>, Flow<T> {

    private var downStream: Consumer<T>? = null

    override fun onNext(data: T) {
        downStream?.onNext(data)
    }

    override fun onError(error: Throwable) {
        downStream?.onError(error)
    }

    override fun onComplete() {
        downStream?.onComplete()
    }

    override fun consume(consumer: Consumer<T>) {
        invariantConsume()
        downStream = consumer
        sourceFactory()
    }

    private fun invariantConsume() {
        if (downStream != null) {
            throw Exception("Emitter already has a consumer")
        }
    }
}