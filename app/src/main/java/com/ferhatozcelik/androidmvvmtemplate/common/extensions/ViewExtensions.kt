package com.ferhatozcelik.androidmvvmtemplate.common.extensions

import android.os.SystemClock
import android.view.View

class OnSingleClickListener(
    private val interval: Long = 1000,
    private val block: (View) -> Unit
) : View.OnClickListener {
    private var lastClickTime: Long = 0
    override fun onClick(view: View) {
        if (SystemClock.elapsedRealtime() - lastClickTime < interval) {
            return
        }
        lastClickTime = SystemClock.elapsedRealtime()
        block(view)
    }
}

fun View.setOnSingleClickListener(block: (View) -> Unit) {
    setOnClickListener(OnSingleClickListener {
        block(it)
    })
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}