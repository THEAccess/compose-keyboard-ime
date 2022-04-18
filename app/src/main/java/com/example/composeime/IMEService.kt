package com.example.composeime

import android.inputmethodservice.InputMethodService
import android.view.View
import androidx.lifecycle.*
import androidx.savedstate.SavedStateRegistry
import androidx.savedstate.SavedStateRegistryController
import androidx.savedstate.SavedStateRegistryOwner
import androidx.savedstate.ViewTreeSavedStateRegistryOwner


class IMEService : InputMethodService(), LifecycleOwner, ViewModelStoreOwner,
    SavedStateRegistryOwner {

    override fun onCreateInputView(): View {
        val view = ComposeKeyboardView(this)
        window!!.window!!.decorView.let { decorView ->
            ViewTreeLifecycleOwner.set(decorView, this)
            ViewTreeViewModelStoreOwner.set(decorView, this)
            ViewTreeSavedStateRegistryOwner.set(decorView, this)
        }
       view.let {
            ViewTreeLifecycleOwner.set(it, this)
            ViewTreeViewModelStoreOwner.set(it, this)
            ViewTreeSavedStateRegistryOwner.set(it, this)
        }
        return view
    }


    //Lifecylce Methods

    private var lifecycleRegistry: LifecycleRegistry = LifecycleRegistry(this)

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }


    private fun handleLifecycleEvent(event: Lifecycle.Event) =
        lifecycleRegistry.handleLifecycleEvent(event)

    override fun onCreate() {
        super.onCreate()
        savedStateRegistry.performRestore(null)
        handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
    }



    override fun onDestroy() {
        super.onDestroy()
        handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    }


    //ViewModelStore Methods
    private val store = ViewModelStore()

    override fun getViewModelStore(): ViewModelStore = store

    //SaveStateRegestry Methods

    private val savedStateRegistry = SavedStateRegistryController.create(this)

    override fun getSavedStateRegistry(): SavedStateRegistry = savedStateRegistry.savedStateRegistry
}