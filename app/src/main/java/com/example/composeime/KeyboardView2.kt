package com.example.composeime

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.AbstractComposeView
import androidx.lifecycle.ViewTreeLifecycleOwner


class KeyboardView2 constructor(
    context: Context,

    ) : AbstractComposeView(context) {

    @Composable
    override fun Content() {
        Keyboard()
       
    }
}