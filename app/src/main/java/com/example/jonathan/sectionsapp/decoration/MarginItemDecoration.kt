package com.example.jonathan.sectionsapp.decoration

import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView
import com.example.jonathan.sectionsapp.R

open class MarginItemDecoration constructor(
    @DimenRes protected val top: Int,
    @DimenRes protected val bottom: Int,
    @DimenRes protected val start: Int,
    @DimenRes protected val end: Int
) : RecyclerView.ItemDecoration() {

    constructor(
        @DimenRes horizontal: Int = R.dimen.no_margin,
        @DimenRes vertical: Int = R.dimen.no_margin
    ) : this(
        top = vertical,
        bottom = vertical,
        start = horizontal,
        end = horizontal
    )

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