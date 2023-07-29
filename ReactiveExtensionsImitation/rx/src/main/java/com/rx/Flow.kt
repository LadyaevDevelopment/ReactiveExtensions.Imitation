package com.rx

interface Flow<T> {
    fun consume(consumer: Consumer<T>)
}