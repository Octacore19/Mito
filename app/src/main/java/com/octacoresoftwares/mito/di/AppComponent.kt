package com.octacoresoftwares.mito.di

import com.google.firebase.auth.FirebaseAuth
import com.octacoresoftwares.mito.ui.login.di.LoginComponent
import com.octacoresoftwares.mito.ui.registration.di.RegistrationComponent
import dagger.BindsInstance
import dagger.Component
import dagger.Module

@Component(
    modules = [ViewModelBuilderModule::class,
        SubComponentModule::class]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance firebaseAuth: FirebaseAuth): AppComponent
    }

    fun loginComponent(): LoginComponent.Factory
    fun registrationComponent(): RegistrationComponent.Factory
}

@Module(
    subcomponents = [LoginComponent::class, RegistrationComponent::class]
)
object SubComponentModule