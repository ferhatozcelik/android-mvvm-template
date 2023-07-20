package com.ferhatozcelik.androidmvvmtemplate.util

import android.app.Activity
import android.app.AlertDialog
import android.graphics.drawable.ColorDrawable
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.RelativeLayout
import com.ferhatozcelik.androidmvvmtemplate.R

class ProgressDialog(var activity: Activity) {
    private val builder = AlertDialog.Builder(activity)
    private var alertDialog = builder.create()
    private var process: Boolean = false

    fun createProgressDialog() {
        process = false
        val view: View = LayoutInflater.from(activity).inflate(R.layout.progress_dialog, activity.findViewById<View>(R.id.layoutDialogContainer) as RelativeLayout?)
        builder.setView(view)
        alertDialog = builder.create()

        if (alertDialog.window != null) {
            alertDialog.window!!.setBackgroundDrawable(ColorDrawable(0))
        }

        val imageView = view.findViewById<ImageView>(R.id.progress_image)


        val rotate = RotateAnimation(0f, 180f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        rotate.duration = 1000
        rotate.repeatCount = Animation.INFINITE
        rotate.repeatMode = Animation.RESTART
        rotate.interpolator = LinearInterpolator()
        imageView.startAnimation(rotate)
        showDialog()
    }

    fun cancelDialog(delayClose: Boolean = false) {
        if (delayClose) {
            Handler().postDelayed({
                if (alertDialog != null) {
                    alertDialog.cancel()
                    process = false
                }
            }, 600)
        } else {
            if (alertDialog != null) {
                alertDialog.cancel()
                process = false
            }

        }
    }

    private fun showDialog() {
        if (!process) {
            alertDialog.setCancelable(false)
            alertDialog.show()
            process = true
        }
    }
}