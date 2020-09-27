package com.octacoresoftwares.mito.ui.user.di

import com.octacoresoftwares.mito.di.AppComponent
import com.octacoresoftwares.mito.di.ViewModelBuilderModule
import com.octacoresoftwares.mito.ui.user.chats.di.ChatsComponent
import com.octacoresoftwares.mito.ui.user.matches.di.MatchesComponent
import com.octacoresoftwares.mito.ui.user.nearby.di.NearbyComponent
import com.octacoresoftwares.mito.ui.user.profile.di.ProfileComponent
import dagger.Component
import dagger.Module

@Component(dependencies = [AppComponent::class], modules = [ViewModelBuilderModule::class, UserSubComponents::class])
interface UserComponent {

    @Component.Factory
    interface Factory {
        fun create(appComponent: AppComponent): UserComponent
    }

    fun chatComponent(): ChatsComponent.Factory
    fun matchesComponent(): MatchesComponent.Factory
    fun nearbyComponent(): NearbyComponent.Factory
    fun profileComponent(): ProfileComponent.Factory
}

@Module(subcomponents = [ChatsComponent::class, MatchesComponent::class, NearbyComponent::class, ProfileComponent::class])
object UserSubComponents