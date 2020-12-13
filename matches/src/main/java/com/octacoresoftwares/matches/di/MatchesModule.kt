package com.octacoresoftwares.matches.di

import com.octacoresoftwares.matches.di.screens.MatchesLandingFragmentModule
import dagger.Module

@Module(
    includes = [
        MatchesLandingFragmentModule::class
    ]
)
object MatchesModule