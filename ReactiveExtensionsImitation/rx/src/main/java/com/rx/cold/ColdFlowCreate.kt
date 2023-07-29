package com.rx.cold

import com.rx.Consumer
import com.rx.Emitter
import com.rx.Flow

class ColdFlowCreate<T>(private val sourceFactory: Consumer<T>.() -> Unit) : Flow<T> {
    override fun consume(consumer: Consumer<T>) {
        val unaryEmitter = Emitter(sourceFactory = sourceFactory)
        unaryEmitter.consume(consumer)
    }
}