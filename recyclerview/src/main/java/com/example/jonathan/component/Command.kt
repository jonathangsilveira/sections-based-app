package com.example.jonathan.component

interface Command<CR: CommandReceiver> {
    fun execute(receiver: CR)
}