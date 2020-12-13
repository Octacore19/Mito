package com.octacoresoftwares.auth.di.screens.registration.host

import com.octacoresoftwares.auth.di.screens.registration.create.CreateAccountFragmentModule
import dagger.Module

@Module(
    includes = [
        CreateAccountFragmentModule::class
    ]
)
object ViewsModule {
}