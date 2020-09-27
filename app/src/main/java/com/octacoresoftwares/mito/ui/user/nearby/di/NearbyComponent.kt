package com.octacoresoftwares.mito.ui.user.nearby.di

import com.octacoresoftwares.mito.ui.user.nearby.NearbyFragment
import dagger.Subcomponent

@Subcomponent(modules = [NearbyModule::class])
interface NearbyComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): NearbyComponent
    }

    fun inject(fragment: NearbyFragment)
}