package com.octacoresoftwares.mito.ui.user.nearby.di

import com.octacoresoftwares.mito.ui.user.nearby.NearbyFragment
import dagger.Subcomponent
import java.io.Serializable

@Subcomponent(modules = [NearbyModule::class])
interface NearbyComponent: Serializable {

    @Subcomponent.Factory
    interface Factory {
        fun create(): NearbyComponent
    }

    fun inject(fragment: NearbyFragment)
}