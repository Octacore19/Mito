package com.octacoresoftwares.mito.ui.registration.di

import com.octacoresoftwares.mito.di.RegistrationScope
import com.octacoresoftwares.mito.ui.registration.RegistrationContainerFragment
import com.octacoresoftwares.mito.ui.registration.fragments.CreateAccountFragment
import dagger.Subcomponent

@RegistrationScope
@Subcomponent(modules = [RegistrationModule::class])
interface RegistrationComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): RegistrationComponent
    }

    fun inject(fragment: RegistrationContainerFragment)
    fun inject(fragment: CreateAccountFragment)
}