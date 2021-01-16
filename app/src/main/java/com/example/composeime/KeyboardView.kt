package com.example.composeime

import android.content.Context
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.ViewTreeLifecycleOwner


class KeyboardView(context: Context) : FrameLayout(context)  {

    init {
        val view = ComposeView(context).apply {
            setContent {
                Keyboard()
            }
        }
        addView(view)
    }

}