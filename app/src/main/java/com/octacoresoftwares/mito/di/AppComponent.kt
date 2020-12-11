package com.octacoresoftwares.mito.di

import com.octacoresoftwares.mito.MitoApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppCoreModules::class
    ]
)
@Singleton
interface AppComponent : AndroidInjector<MitoApplication>{

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance superApp: MitoApplication): AppComponent
    }
}
