package com.octacoresoftwares.mito.di

import com.google.firebase.auth.FirebaseAuth
import com.octacoresoftwares.mito.ui.chats.di.ChatsComponent
import com.octacoresoftwares.mito.ui.login.di.LoginComponent
import com.octacoresoftwares.mito.ui.matches.di.MatchesComponent
import com.octacoresoftwares.mito.ui.nearby.di.NearbyComponent
import com.octacoresoftwares.mito.ui.profile.di.ProfileComponent
import com.octacoresoftwares.mito.ui.registration.di.RegistrationComponent
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

    fun chatComponent(): ChatsComponent.Factory
    fun matchesComponent(): MatchesComponent.Factory
    fun nearbyComponent(): NearbyComponent.Factory
    fun profileComponent(): ProfileComponent.Factory
    fun loginComponent(): LoginComponent.Factory
    fun registrationComponent(): RegistrationComponent.Factory
}

@Module(
    subcomponents = [ChatsComponent::class, MatchesComponent::class,
        NearbyComponent::class, ProfileComponent::class, LoginComponent::class, RegistrationComponent::class]
)
object SubComponentModule