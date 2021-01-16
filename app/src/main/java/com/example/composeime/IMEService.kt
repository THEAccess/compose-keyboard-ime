package com.example.composeime

import android.inputmethodservice.InputMethodService
import android.view.View


class IMEService : InputMethodService() {

    override fun onCreateInputView(): View = KeyboardView(this)
}