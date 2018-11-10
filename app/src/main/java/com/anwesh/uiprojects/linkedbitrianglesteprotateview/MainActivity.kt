package com.anwesh.uiprojects.linkedbitrianglesteprotateview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import com.anwesh.uiprojects.bitrianglesteprotateview.BiTriangleRotateStepView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view : BiTriangleRotateStepView = BiTriangleRotateStepView.create(this)
        fullScreen()
        view.addOnAnimationListener({createToast("animation number $it is complete")}, {createToast("animation number $it is reset")})
    }

    fun createToast(txt : String) {
        Toast.makeText(this, txt, Toast.LENGTH_SHORT).show()
    }
}

fun MainActivity.fullScreen() {
    supportActionBar?.hide()
    window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
}