package com.octacoresoftwares.profile.di

import com.octacoresoftwares.profile.ProfileHostFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ProfileFragmentModule {

    @ContributesAndroidInjector(modules = [ProfileModule::class])
    abstract fun bindsMatchesFragment(): ProfileHostFragment
}