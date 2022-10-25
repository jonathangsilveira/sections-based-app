package com.example.jonathan.sectionsapp.decoration

import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView

class HorizontalItemDecorator(
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
        val lastPosition = parent.getLastPositionOrNoPosition()
        if (lastPosition == RecyclerView.NO_POSITION) return
        val currentIndex = parent.getChildAdapterPosition(view)
        val isLastIndex = currentIndex == lastPosition
        outRect.top = 0
        outRect.bottom = 0
        outRect.left = resources.getDimension(start).toInt()
        outRect.right = if (isLastIndex) 0 else resources.getDimension(end).toInt()
    }

    private fun RecyclerView.getLastPositionOrNoPosition(): Int {
        return adapter?.itemCount?.minus(1) ?: RecyclerView.NO_POSITION
    }
}