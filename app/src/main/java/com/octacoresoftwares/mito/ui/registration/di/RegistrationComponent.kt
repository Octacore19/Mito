package com.octacoresoftwares.mito.ui.registration.di

import com.octacoresoftwares.mito.di.RegistrationScope
import com.octacoresoftwares.mito.ui.registration.create.CreateAccountFragment
import com.octacoresoftwares.mito.ui.registration.create.di.CreateAccountComponent
import com.octacoresoftwares.mito.ui.registration.name.di.NameRegistrationComponent
import dagger.Module
import dagger.Subcomponent

@RegistrationScope
@Subcomponent(modules = [RegistrationSubComponents::class, RegistrationModule::class])
interface RegistrationComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): RegistrationComponent
    }

    fun createAccountComponent(): CreateAccountComponent.Factory
    fun nameRegistrationComponent(): NameRegistrationComponent.Factory
}

@Module(subcomponents = [CreateAccountComponent::class, NameRegistrationComponent::class])
object RegistrationSubComponents