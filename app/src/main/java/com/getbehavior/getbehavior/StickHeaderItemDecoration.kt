package com.getbehavior.getbehavior

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.TextPaint
import android.view.View

class StickHeaderItemDecoration : RecyclerView.ItemDecoration {

    private var data: List<Race> = ArrayList()
    private val paint = TextPaint()

    constructor(data:List<Race>) : super() {
        this.data = data
        paint.isAntiAlias = true
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.textSize = 18f
        paint.color = Color.CYAN
        paint.textAlign = Paint.Align.CENTER
    }


    var currTitle = ""

    override fun getItemOffsets(outRect: Rect, view: View, recyclerView: RecyclerView, state: RecyclerView.State) {

        var adapterPosition = recyclerView.getChildAdapterPosition(view)
        if (data[adapterPosition].type == 0)
            outRect.set(0,100,recyclerView.width,0)
        else outRect.set(0,0,0,0)
    }


    override fun onDraw(c: Canvas, recyclerView: RecyclerView, state: RecyclerView.State?) {
        super.onDraw(c, recyclerView, state)
        val layoutManager = recyclerView.layoutManager as LinearLayoutManager
        val start = layoutManager.findFirstVisibleItemPosition()

    }

    /**
     * 覆写此方法
     */
    override fun onDrawOver(c: Canvas, recyclerView: RecyclerView, state: RecyclerView.State) {
        var layoutManager = recyclerView.layoutManager as LinearLayoutManager
        var itemPosition = layoutManager.findFirstVisibleItemPosition()
//        var view = View(recyclerView.context)
//        view.draw(c)

        var item = data[itemPosition]
        var offset = 0
        //最顶端显示的是个title，我们draw一个假的在上面
        if (item.type == 0) {
            currTitle = item.title
            offset = recyclerView.findViewHolderForAdapterPosition(itemPosition).itemView.top
            c.save()
//            c.drawText(currTitle, recyclerView.width/2,)
            c.restore()
        }
    }

}