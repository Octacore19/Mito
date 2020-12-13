package com.octacoresoftwares.nearby.di.screens

import com.octacoresoftwares.nearby.di.modules.NearbyLandingModule
import com.octacoresoftwares.nearby.screens.NearbyLandingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class NearbyLandingFragmentModule {

    @ContributesAndroidInjector(modules = [NearbyLandingModule::class])
    abstract fun bindsNearbyLandingFragment(): NearbyLandingFragment
}