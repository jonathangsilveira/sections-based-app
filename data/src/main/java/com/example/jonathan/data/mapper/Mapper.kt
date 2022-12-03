package com.example.jonathan.data.mapper

internal interface Mapper<in T, out R> {
    fun map(value: T): R
}