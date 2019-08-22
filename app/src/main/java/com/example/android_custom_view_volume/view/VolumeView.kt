package com.example.android_custom_view_volume.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class VolumeView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val rect = Rect()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var startX: Float = 0f
    private var startY: Float = 0f
    private var diffX: Float = 0f
    private var diffY: Float = 0f

    init {

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action) {
            MotionEvent.ACTION_DOWN -> {
                startX = event.x
                startY = event.y
            }
            MotionEvent.ACTION_UP -> {
                diffX = event.x - startX
                diffY = event.y - startY
            }
            MotionEvent.ACTION_MOVE -> {
            }
        }
        invalidate()
        return true
    }

    private fun largeCircle(canvas: Canvas?) {
        val w = width/3f
        val h = height/3f
        var r = 0f

        if (w >= h) {
            r = w
        } else {
            r = h
        }

        paint.setColor(Color.BLACK)

        canvas?.drawCircle(width/2f, height/2f, r, paint)

    }

    private fun smallCircle(canvas: Canvas?) {

        val w = width/15f
        val h = height/15f
        var r = 0f

        if (w >= h) {
            r = w
        } else {
            r = h
        }

        paint.setColor(Color.RED)

        canvas?.drawCircle(width/2f, height/2f, r, paint)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        largeCircle(canvas)
        smallCircle(canvas)
    }
}