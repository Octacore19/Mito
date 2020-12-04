package com.octacoresoftwares.mito.screens.registration.contact.di

import com.octacoresoftwares.mito.screens.registration.contact.ContactRegistrationFragment
import dagger.Subcomponent
import java.io.Serializable

@Subcomponent(modules = [ContactRegistrationModule::class])
interface ContactRegistrationComponent: Serializable {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ContactRegistrationComponent
    }

    fun inject(fragment: ContactRegistrationFragment)
}