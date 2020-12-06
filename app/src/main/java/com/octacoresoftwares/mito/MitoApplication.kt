package com.octacoresoftwares.mito

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MitoApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initTheme()
    }

    private fun initTheme() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    // Instance of the AppComponent that will be used by all the Activities in the project
    /*val appComponent by lazy {
        initializeComponent()
    }*/

//    private fun initializeComponent() = DaggerAppComponent.factory().create(Firebase.auth)
}