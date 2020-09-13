package com.octacoresoftwares.mito.ui.nearby.di

import com.octacoresoftwares.mito.ui.nearby.NearbyFragment
import dagger.Subcomponent

@Subcomponent(modules = [NearbyModule::class])
interface NearbyComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): NearbyComponent
    }

    fun inject(fragment: NearbyFragment)
}