package com.octacoresoftwares.mito.screens.registration.di

import com.google.firebase.firestore.FirebaseFirestore
import com.octacoresoftwares.mito.di.RegistrationScope
import com.octacoresoftwares.mito.screens.registration.contact.di.ContactRegistrationComponent
import com.octacoresoftwares.mito.screens.registration.create.di.CreateAccountComponent
import com.octacoresoftwares.mito.screens.registration.name.di.NameRegistrationComponent
import com.octacoresoftwares.mito.screens.registration.other.di.OtherInformationComponent
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent
import java.io.Serializable

@RegistrationScope
@Subcomponent(modules = [RegistrationSubComponents::class, RegistrationModule::class])
interface RegistrationComponent : Serializable {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance database: FirebaseFirestore): RegistrationComponent
    }

    fun createAccountComponent(): CreateAccountComponent.Factory
    fun nameRegistrationComponent(): NameRegistrationComponent.Factory
    fun otherInformationComponent(): OtherInformationComponent.Factory
    fun contactRegistrationComponent(): ContactRegistrationComponent.Factory
}

@Module(subcomponents = [CreateAccountComponent::class, NameRegistrationComponent::class,
    OtherInformationComponent::class, ContactRegistrationComponent::class])
object RegistrationSubComponents