package com.octacoresoftwares.mito

import androidx.appcompat.app.AppCompatDelegate
import com.octacoresoftwares.mito.di.AppComponent
import com.octacoresoftwares.mito.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

class MitoApplication : DaggerApplication() {

    lateinit var appComponent: AppComponent

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        initTheme()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = DaggerAppComponent.factory()
            .create(this)
        return appComponent
    }

    private fun initTheme() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

}