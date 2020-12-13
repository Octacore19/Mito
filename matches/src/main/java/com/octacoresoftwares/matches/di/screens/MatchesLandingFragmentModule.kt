package com.octacoresoftwares.matches.di.screens

import com.octacoresoftwares.matches.di.modules.MatchesLandingModule
import com.octacoresoftwares.matches.screens.MatchesLandingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MatchesLandingFragmentModule {

    @ContributesAndroidInjector(modules = [MatchesLandingModule::class])
    abstract fun bindsMatchesLandingFragment(): MatchesLandingFragment
}