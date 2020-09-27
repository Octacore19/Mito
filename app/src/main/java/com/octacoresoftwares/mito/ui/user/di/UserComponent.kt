package com.octacoresoftwares.mito.ui.user.di

import com.octacoresoftwares.mito.ui.user.chats.di.ChatsComponent
import com.octacoresoftwares.mito.ui.user.matches.di.MatchesComponent
import com.octacoresoftwares.mito.ui.user.nearby.di.NearbyComponent
import com.octacoresoftwares.mito.ui.user.profile.di.ProfileComponent
import dagger.Module
import dagger.Subcomponent

@Subcomponent(modules = [UserSubComponents::class])
interface UserComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): UserComponent
    }

    fun chatComponent(): ChatsComponent.Factory
    fun matchesComponent(): MatchesComponent.Factory
    fun nearbyComponent(): NearbyComponent.Factory
    fun profileComponent(): ProfileComponent.Factory
}

@Module(subcomponents = [ChatsComponent::class, MatchesComponent::class, NearbyComponent::class, ProfileComponent::class])
object UserSubComponents