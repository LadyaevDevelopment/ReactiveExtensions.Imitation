package com.rx.cold

import com.rx.Consumer
import com.rx.Flow

class ColdFlow {
    companion object {
        fun<T> create(factory: Consumer<T>.() -> Unit) : Flow<T> {
            return ColdFlowCreate(sourceFactory = factory)
        }
    }
}