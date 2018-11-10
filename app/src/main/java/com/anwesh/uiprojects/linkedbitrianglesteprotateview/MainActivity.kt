package com.anwesh.uiprojects.linkedbitrianglesteprotateview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesh.uiprojects.bitrianglesteprotateview.BiTriangleRotateStepView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BiTriangleRotateStepView.create(this)
    }
}
