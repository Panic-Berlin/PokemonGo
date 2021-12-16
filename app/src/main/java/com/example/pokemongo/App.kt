package com.example.pokemongo

import android.app.Application
import androidx.fragment.app.Fragment
import com.example.pokemongo.di.DaggerAppComponent

class App : Application() {
    val appComponent = DaggerAppComponent.builder().build()
}

val Fragment.appComponent
    get() = (requireContext().applicationContext as App).appComponent
