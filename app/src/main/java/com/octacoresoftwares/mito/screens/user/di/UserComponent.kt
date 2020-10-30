package com.octacoresoftwares.mito.screens.user.di

import com.google.firebase.firestore.FirebaseFirestore
import com.octacoresoftwares.mito.di.LoggedInUser
import com.octacoresoftwares.mito.screens.user.chats.di.ChatsComponent
import com.octacoresoftwares.mito.screens.user.matches.di.MatchesComponent
import com.octacoresoftwares.mito.screens.user.nearby.di.NearbyComponent
import com.octacoresoftwares.mito.screens.user.profile.di.ProfileComponent
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent

@LoggedInUser
@Subcomponent(modules = [UserSubComponents::class])
interface UserComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance database: FirebaseFirestore): UserComponent
    }

    fun chatComponent(): ChatsComponent.Factory
    fun matchesComponent(): MatchesComponent.Factory
    fun nearbyComponent(): NearbyComponent.Factory
    fun profileComponent(): ProfileComponent.Factory
}

@Module(subcomponents = [ChatsComponent::class, MatchesComponent::class, NearbyComponent::class, ProfileComponent::class])
object UserSubComponents