package com.octacoresoftwares.nearby.di

import com.octacoresoftwares.nearby.NearbyHostFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class NearbyFragmentModule {

    @ContributesAndroidInjector(modules = [NearbyModule::class])
    abstract fun bindsNearbyFragment(): NearbyHostFragment
}