package com.octacoresoftwares.mito

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.octacoresoftwares.mito.di.AppComponent
import com.octacoresoftwares.mito.di.DaggerAppComponent

class MikoApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initTheme()
    }

    private fun initTheme() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    // Instance of the AppComponent that will be used by all the Activities in the project
    val appComponent by lazy {
        initializeComponent()
    }

    private fun initializeComponent(): AppComponent {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        return DaggerAppComponent.factory().create()
    }
}