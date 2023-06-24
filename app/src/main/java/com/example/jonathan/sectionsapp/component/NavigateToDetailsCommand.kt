package com.example.jonathan.sectionsapp.component

import com.example.jonathan.component.Command

class NavigateToDetailsCommand(
    private val id: Long
): Command<HomeCommandReceiver> {
    override fun execute(receiver: HomeCommandReceiver) {
        receiver.navigateToDetails(id)
    }
}