package com.example.jonathan.sectionsapp.decoration

import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView

class MarginItemDecoration(
    @DimenRes private val top: Int,
    @DimenRes private val bottom: Int,
    @DimenRes private val start: Int,
    @DimenRes private val end: Int
): RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val resources = view.resources
        outRect.top = resources.getDimension(top).toInt()
        outRect.bottom = resources.getDimension(bottom).toInt()
        outRect.left = resources.getDimension(start).toInt()
        outRect.right = resources.getDimension(end).toInt()
    }
}