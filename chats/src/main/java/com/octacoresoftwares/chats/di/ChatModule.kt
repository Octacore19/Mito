package com.octacoresoftwares.chats.di

import com.octacoresoftwares.chats.di.screens.ChatLandingFragmentModule
import dagger.Module

@Module(
    includes = [
        ChatLandingFragmentModule::class
    ]
)
object ChatModule