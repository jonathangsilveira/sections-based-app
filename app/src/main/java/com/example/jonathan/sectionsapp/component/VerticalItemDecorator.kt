package com.example.jonathan.sectionsapp.component

import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView

class VerticalItemDecorator(
    @DimenRes private val top: Int,
    @DimenRes private val bottom: Int
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
        outRect.top = resources.getDimension(top).toInt()
        outRect.bottom = if (isLastIndex) 0 else resources.getDimension(bottom).toInt()
        outRect.left = 0
        outRect.right = 0
    }

    private fun RecyclerView.getLastPositionOrNoPosition(): Int {
        return adapter?.itemCount?.minus(1) ?: RecyclerView.NO_POSITION
    }
}