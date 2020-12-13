package com.octacoresoftwares.profile.di.screens

import com.octacoresoftwares.profile.di.modules.ProfileLandingModule
import com.octacoresoftwares.profile.screens.ProfileLandingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ProfileLandingFragmentModule {

    @ContributesAndroidInjector(modules = [ProfileLandingModule::class])
    abstract fun bindsProfileLandingFragment(): ProfileLandingFragment
}