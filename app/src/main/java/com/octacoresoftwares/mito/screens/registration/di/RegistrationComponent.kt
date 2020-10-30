package com.octacoresoftwares.mito.screens.registration.di

import com.google.firebase.firestore.FirebaseFirestore
import com.octacoresoftwares.mito.di.RegistrationScope
import com.octacoresoftwares.mito.screens.registration.create.di.CreateAccountComponent
import com.octacoresoftwares.mito.screens.registration.name.di.NameRegistrationComponent
import dagger.Module
import dagger.Subcomponent
import java.io.Serializable

@RegistrationScope
@Subcomponent(modules = [RegistrationSubComponents::class, RegistrationModule::class])
interface RegistrationComponent: Serializable {

    @Subcomponent.Factory
    interface Factory {
        fun create(database: FirebaseFirestore): RegistrationComponent
    }

    fun createAccountComponent(): CreateAccountComponent.Factory
    fun nameRegistrationComponent(): NameRegistrationComponent.Factory
}

@Module(subcomponents = [CreateAccountComponent::class, NameRegistrationComponent::class])
object RegistrationSubComponents