package com.octacoresoftwares.mito.di

import com.google.firebase.auth.FirebaseAuth
import com.octacoresoftwares.mito.screens.login.di.LoginComponent
import com.octacoresoftwares.mito.screens.registration.di.RegistrationComponent
import com.octacoresoftwares.mito.screens.user.UserManager
import com.octacoresoftwares.mito.screens.user.di.UserComponent
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Component(
    modules = [ViewModelBuilderModule::class,
        SubComponentModule::class]
)
@Singleton
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance firebaseAuth: FirebaseAuth): AppComponent
    }

    fun loginComponent(): LoginComponent.Factory
    fun registrationComponent(): RegistrationComponent.Factory
    fun userManager(): UserManager
}

@Module(
    subcomponents = [LoginComponent::class, RegistrationComponent::class, UserComponent::class]
)
object SubComponentModule