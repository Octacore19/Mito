package com.octacoresoftwares.mito.screens.login.di

import com.octacoresoftwares.mito.screens.login.LoginFragment
import dagger.Subcomponent
import java.io.Serializable

@Subcomponent(modules = [LoginModule::class])
interface LoginComponent: Serializable {

    @Subcomponent.Factory
    interface Factory {
        fun create(): LoginComponent
    }

    fun inject(fragment: LoginFragment)
}