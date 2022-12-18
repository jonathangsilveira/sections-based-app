package com.example.jonathan.sectionsapp.decoration

import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView
import com.example.jonathan.sectionsapp.R
import kotlin.time.Duration.Companion.seconds

class GridMarginItemDecoration constructor(
    @DimenRes top: Int,
    @DimenRes bottom: Int,
    @DimenRes start: Int,
    @DimenRes end: Int
): MarginItemDecoration(top, bottom, start, end) {

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
        val position = parent.getChildAdapterPosition(view)
        if (position == RecyclerView.NO_POSITION) return
        val resources = view.resources
        val mod = position.mod(2)
        if (mod == 0) {
            outRect.left = resources.getDimension(start).toInt()
            outRect.right = resources.getDimension(end).toInt()
        } else {
            outRect.left = resources.getDimension(end).toInt()
            outRect.right = resources.getDimension(start).toInt()
        }
        outRect.top = resources.getDimension(top).toInt()
        outRect.bottom = resources.getDimension(bottom).toInt()
    }
}