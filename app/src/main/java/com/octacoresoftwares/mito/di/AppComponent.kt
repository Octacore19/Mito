package com.octacoresoftwares.mito.di

import com.octacoresoftwares.mito.ui.chats.di.ChatsComponent
import com.octacoresoftwares.mito.ui.matches.di.MatchesComponent
import com.octacoresoftwares.mito.ui.nearby.di.NearbyComponent
import com.octacoresoftwares.mito.ui.profile.di.ProfileComponent
import dagger.Component
import dagger.Module

@Component(
    modules = [ViewModelBuilderModule::class,
        SubComponentModule::class]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(): AppComponent
    }

    fun chatComponent(): ChatsComponent.Factory
    fun matchesComponent(): MatchesComponent.Factory
    fun nearbyComponent(): NearbyComponent.Factory
    fun profileComponent(): ProfileComponent.Factory
}

@Module(subcomponents = [ChatsComponent::class, MatchesComponent::class])
object SubComponentModule