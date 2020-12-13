package com.octacoresoftwares.chats.di.screens

import com.octacoresoftwares.chats.di.modules.ChatLandingModule
import com.octacoresoftwares.chats.screens.ChatsLandingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ChatLandingFragmentModule {

    @ContributesAndroidInjector(modules = [ChatLandingModule::class])
    abstract fun bindsChatLandingFragment(): ChatsLandingFragment
}