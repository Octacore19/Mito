package com.octacoresoftwares.mito.di.modules.screens.auth

import com.octacoresoftwares.auth.di.AuthFragmentModules
import com.octacoresoftwares.mito.di.modules.firebase.FirebaseAuthenticationModule
import dagger.Module

@Module(
    includes = [
        AuthFragmentModules::class,
        FirebaseAuthenticationModule::class,
        NavigationModule::class
    ]
)
object AuthModule