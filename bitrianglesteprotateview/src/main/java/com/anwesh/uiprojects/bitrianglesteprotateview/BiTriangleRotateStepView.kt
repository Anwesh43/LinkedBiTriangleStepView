package com.anwesh.uiprojects.bitrianglesteprotateview

/**
 * Created by anweshmishra on 10/11/18.
 */

import android.view.View
import android.view.MotionEvent
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.app.Activity
import android.content.Context

val nodes : Int = 5

val CROSS_LINES : Int = 4

val TRI_LINES : Int = 2

val PARTS : Int = 3

val FACTOR : Double = 1.0 / PARTS

val SC_GAP : Float = 0.1f / PARTS

fun Int.getInverse() : Float = 1f / this

fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.getInverse(), Math.max(0f, this - i * n.getInverse())) * n

fun Float.getFactor() : Float = Math.floor(this / FACTOR).toFloat()

fun Float.updateScale(dir : Int) : Float {
    val k : Float = getFactor()
    val f1 : Float =  ((1 - k) * (2 - k) / 2) / CROSS_LINES
    val f2 : Float = ((k) * (2 - k)) / TRI_LINES
    val f3 : Float = k
    return SC_GAP * dir * (f1 + f2 + f3)
}

fun Canvas.drawBRTSNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = w / (nodes + 1)
    val sc1 : Float = scale.divideScale(0, 3)
    val sc2 : Float = scale.divideScale(1, 3)
    val sc3 : Float = scale.divideScale(2, 3)
    val size : Float = gap / 3
    val degCross : Float = 360f / CROSS_LINES
    val degTri : Float = 360f / TRI_LINES
    paint.strokeWidth = Math.min(w, h) / 60
    paint.strokeCap = Paint.Cap.ROUND
    paint.color = Color.parseColor("#01579B")
    save()
    translate(gap + gap * i, h/2)
    rotate(180f * sc3)
    for (j in 0..(CROSS_LINES - 1)) {
        val sc : Float = sc1.divideScale(j, CROSS_LINES)
        save()
        rotate(degCross)
        drawLine(0f, 0f, size * sc, size * sc, paint)
        restore()
    }
    for (j in 0..(TRI_LINES - 1)) {
        val sc : Float = sc2.divideScale(j, TRI_LINES)
        save()
        rotate(degTri)
        translate(0f, size)
        drawLine(size, 0f, size - 2 * size * sc, 0f, paint)
        restore()
    }
    restore()
}

class BiTriangleRotateStepView(ctx : Context) : View(ctx) {

    private val paint : Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}