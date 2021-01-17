package com.example.composeime

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun Keyboard() {
    Box(
        Modifier.fillMaxWidth().height(200.dp).background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Text(color = Color.White, text = "This should resemble a keyboard (Compose)")
    }
}