package com.octacoresoftwares.mito.screens.registration.name.di

import com.octacoresoftwares.mito.screens.registration.name.NameRegistrationFragment
import dagger.Subcomponent
import java.io.Serializable

@Subcomponent(modules = [NameRegistrationModule::class])
interface NameRegistrationComponent: Serializable {

    @Subcomponent.Factory
    interface Factory {
        fun create(): NameRegistrationComponent
    }

    fun inject(fragment: NameRegistrationFragment)
}