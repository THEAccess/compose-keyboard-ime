package com.example.composeime

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.ViewTreeLifecycleOwner


class AndroidKeyboardView(context: Context) : FrameLayout(context) {

    init {
        inflate(context,R.layout.example_layout, this)
    }

}