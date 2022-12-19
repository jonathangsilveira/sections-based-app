package com.example.jonathan.domain.mapper

interface Mapper<in T, out R> {
    fun map(value: T): R
}