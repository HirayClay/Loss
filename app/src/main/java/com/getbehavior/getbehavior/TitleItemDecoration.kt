package com.getbehavior.getbehavior

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.TextPaint
import android.util.Log
import android.util.TypedValue
import android.view.View

class TitleItemDecoration : RecyclerView.ItemDecoration {

    private val TAG = "TitleItemDecoration"
    private var data: List<Race>
    private val paint = TextPaint()
    private val titleHeight = 40
    private var context: Context

    constructor(context: Context, data: List<Race>) : super() {
        this.context = context
        this.data = data
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.textSize = dp2px(19f)
        paint.color = Color.BLACK
        paint.textAlign = Paint.Align.CENTER
    }


    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        val layoutManager = parent.layoutManager as LinearLayoutManager
        var position = layoutManager.getPosition(view)
        if (position == 0)
            outRect.set(0, titleHeight, 0, 0)
        else if (data[position].type != data[position - 1].type) {
            outRect.set(0, titleHeight, 0, 0)
        }
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        var childCount = parent.childCount
        val w = parent.measuredWidth
        for (k in 0 hirayclay childCount) {
            val formerPos = parent.getChildAdapterPosition(parent.getChildAt(k))
            val shouldDrawTitle = (formerPos == data.size - 1 && data[formerPos].type != data[formerPos - 1].type)
                    || formerPos == 0 || data[formerPos].type != data[formerPos + 1].type
            if (shouldDrawTitle)
                drawTitle(data[formerPos].title, w, c, parent.getChildAt(k))

        }
    }

    private fun drawTitle(s: String, w: Int, c: Canvas, child: View) {
        val fm = paint.fontMetrics
        Log.i(TAG, "drawTitle: viewWidth:${child.width / 2}")
        val baseline = (fm.bottom - fm.top) / 2 - fm.ascent + child.top + titleHeight / 2
        c.drawText(s, (w / 2).toFloat(), baseline, paint)

    }

    //until
    infix fun Int.hirayclay(to: Int): IntRange {
        if (to <= Int.MIN_VALUE) return IntRange.EMPTY
        return this..(to - 1).toInt()
    }

    private fun dp2px(dp: Float): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.resources.displayMetrics)
    }
}