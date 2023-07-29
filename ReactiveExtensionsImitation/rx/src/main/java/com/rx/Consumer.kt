package com.rx

interface Consumer<T> {
    fun onNext(data: T)
    fun onError(error: Throwable)
    fun onComplete()
}