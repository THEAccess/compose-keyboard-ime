package com.example.composeime

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import com.example.composeime.ui.ComposeIMETheme
import splitties.systemservices.inputMethodManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeIMETheme {
                Surface(color = MaterialTheme.colors.background) {
                    Options()
                }
            }
        }
    }
}

@Composable
fun Options() {
    Column(Modifier.padding(16.dp).fillMaxSize()) {
        val ctx = AmbientContext.current
        Text(text = "Compose Keyboard")
        Spacer(modifier = Modifier.height(16.dp))
        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            ctx.startActivity(Intent(Settings.ACTION_INPUT_METHOD_SETTINGS))
        }) {
            Text(text = "Enable IME")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            inputMethodManager.showInputMethodPicker()
        }) {
            Text(text = "Select IME")
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextField(value = "Try here", onValueChange = { /*TODO*/ }, modifier = Modifier.fillMaxWidth())

    }
}
