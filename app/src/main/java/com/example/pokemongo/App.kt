package com.example.pokemongo

import android.app.Application
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.pokemongo.di.DaggerAppComponent

class App : Application() {
    val appComponent = DaggerAppComponent
        .builder()
        .context(this)
        .build()
}

val Fragment.appComponent
    get() = (requireContext().applicationContext as App).appComponent
