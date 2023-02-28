package com.example.jonathan.sectionsapp

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.setHorizontalLayoutManager(reverseLayout: Boolean) {
    layoutManager = LinearLayoutManager(RecyclerView.HORIZONTAL, reverseLayout)
}

fun RecyclerView.setVerticalLayoutManager(reverseLayout: Boolean) {
    layoutManager = LinearLayoutManager(RecyclerView.VERTICAL, reverseLayout)
}

private fun RecyclerView.LinearLayoutManager(
    orientation: Int,
    reverseLayout: Boolean
) = LinearLayoutManager(context, orientation, reverseLayout)