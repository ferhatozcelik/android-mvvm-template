package com.ferhatozcelik.androidmvvmtemplate.util

import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

// General-purpose Context/View/String helpers live in `common.extensions` to avoid
// duplication - this file only holds coroutine/lifecycle related helpers.

fun EditText.modifyText(numberText: String) {
    this.setText(numberText)
    this.setSelection(numberText.length)
}

/**
 * Collects [flow] safely, only while the fragment's view is at least in the [STARTED][Lifecycle.State.STARTED]
 * state, automatically pausing/resuming collection across the fragment's lifecycle. This is the
 * recommended pattern for observing a ViewModel's `StateFlow`/`SharedFlow` from a Fragment.
 */
fun <T> Fragment.collectOnStarted(flow: Flow<T>, action: suspend (T) -> Unit) {
    viewLifecycleOwner.lifecycleScope.launch {
        viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow.collectLatest(action)
        }
    }
}
