package com.octacoresoftwares.mito.screens.registration.other.di

import com.octacoresoftwares.mito.screens.registration.other.OtherInformationFragment
import dagger.Subcomponent
import java.io.Serializable

@Subcomponent(modules = [OtherInformationModule::class])
interface OtherInformationComponent: Serializable {

    @Subcomponent.Factory
    interface Factory {
        fun create(): OtherInformationComponent
    }

    fun inject(fragment: OtherInformationFragment)
}