package com.octacoresoftwares.mito.di

import com.google.firebase.auth.FirebaseAuth
import com.octacoresoftwares.core.di.ViewModelBuilderModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [ViewModelBuilderModule::class/*,
        SubComponentModule::class*/]
)
@Singleton
interface AppComponent {

   @Component.Factory
    interface Factory {
        fun create(@BindsInstance firebaseAuth: FirebaseAuth): AppComponent
    }

    /*fun loginComponent(): LoginComponent.Factory
    fun registrationComponent(): RegistrationComponent.Factory
    fun userManager(): UserManager*/
}

/*
@Module(
    subcomponents = [*/
/*LoginComponent::class, RegistrationComponent::class,*//*
 UserComponent::class]
)
object SubComponentModule*/
