package com.example.composeime

import android.content.Context
import android.widget.FrameLayout
import androidx.compose.ui.platform.ComposeView

/**
 * Created by Yannick Knoll on 2021-03-15.
 */
class AndroidKeyboardView(context: Context) : FrameLayout(context) {

    init {
        inflate(context, R.layout.keyboard_view, this)
        findViewById<ComposeView>(R.id.compose_view).setContent {
            KeyboardScreen()
        }
    }


}