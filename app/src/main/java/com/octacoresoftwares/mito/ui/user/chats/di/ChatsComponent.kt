package com.octacoresoftwares.mito.ui.user.chats.di

import com.octacoresoftwares.mito.ui.user.chats.ChatsFragment
import dagger.Subcomponent

@Subcomponent(modules = [ChatsModule::class])
interface ChatsComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create(): ChatsComponent
    }

    fun inject(fragment: ChatsFragment)
}