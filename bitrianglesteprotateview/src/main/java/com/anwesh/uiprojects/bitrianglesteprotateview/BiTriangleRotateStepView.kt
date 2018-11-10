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