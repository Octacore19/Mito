package com.octacoresoftwares.profile.di

import com.octacoresoftwares.profile.di.screens.ProfileLandingFragmentModule
import dagger.Module

@Module(
    includes = [
        ProfileLandingFragmentModule::class
    ]
)
object ProfileModule