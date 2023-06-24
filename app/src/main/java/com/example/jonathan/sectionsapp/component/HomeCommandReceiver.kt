package com.example.jonathan.sectionsapp.component

import com.example.jonathan.component.CommandReceiver

interface HomeCommandReceiver : CommandReceiver {
    fun navigateToDetails(id: Long)
}