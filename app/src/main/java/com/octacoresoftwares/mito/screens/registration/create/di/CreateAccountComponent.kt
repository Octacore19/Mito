package com.octacoresoftwares.mito.screens.registration.create.di

import com.octacoresoftwares.mito.screens.registration.create.CreateAccountFragment
import dagger.Subcomponent
import java.io.Serializable

@Subcomponent(modules = [CreateAccountModule::class])
interface CreateAccountComponent: Serializable {

    @Subcomponent.Factory
    interface Factory {
        fun create(): CreateAccountComponent
    }

    fun inject(fragment: CreateAccountFragment)
}