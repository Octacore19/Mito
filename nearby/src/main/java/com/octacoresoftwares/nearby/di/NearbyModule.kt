package com.octacoresoftwares.nearby.di

import com.octacoresoftwares.nearby.di.screens.NearbyLandingFragmentModule
import dagger.Module

@Module(
    includes = [
        NearbyLandingFragmentModule::class
    ]
)
object NearbyModule