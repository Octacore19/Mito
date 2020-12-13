package com.octacoresoftwares.matches.di

import com.octacoresoftwares.matches.MatchesHostFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MatchesFragmentModule {

    @ContributesAndroidInjector(modules = [MatchesModule::class])
    abstract fun bindsMatchesFragment(): MatchesHostFragment
}