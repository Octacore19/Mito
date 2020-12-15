package com.octacoresoftwares.auth.di.screens.registration.host

import com.octacoresoftwares.auth.di.screens.registration.create.CreateAccountFragmentModule
import com.octacoresoftwares.auth.di.screens.registration.name.NameRegistrationFragmentModule
import dagger.Module

@Module(
    includes = [
        CreateAccountFragmentModule::class,
        NameRegistrationFragmentModule::class
    ]
)
object ViewsModule {
}