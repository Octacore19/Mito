package com.octacoresoftwares.mito.ui.chats.di

import com.octacoresoftwares.mito.ui.chats.ChatsFragment
import dagger.Subcomponent

@Subcomponent(modules = [ChatsModule::class])
interface ChatsComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create(): ChatsComponent
    }

    fun inject(fragment: ChatsFragment)
}