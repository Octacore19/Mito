package com.octacoresoftwares.mito

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class MikoApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initTheme()
    }

    private fun initTheme() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}