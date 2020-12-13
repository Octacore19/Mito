package com.octacoresoftwares.chats.di

import com.octacoresoftwares.chats.ChatsHostFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ChatsFragmentModule {

    @ContributesAndroidInjector(modules = [ChatModule::class])
    abstract fun bindsChatsFragment(): ChatsHostFragment
}