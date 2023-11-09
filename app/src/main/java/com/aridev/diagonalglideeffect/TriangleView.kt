package com.aridev.diagonalglideeffect

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.view.View

class TriangleView (context : Context, color : Int) : View(context) {

    private val paint = Paint()
    private val path = Path()

    init {
        paint.color = color
        paint.style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.let {
            val width = width.toFloat()
            val height = height.toFloat()

            path.moveTo(0f, height)
            path.lineTo(width, height)
            path.lineTo(0f, 0f)
            path.close()

            canvas.drawPath(path, paint)
        }
    }
}