package com.octacoresoftwares.mito.ui.profile.di

import com.octacoresoftwares.mito.ui.profile.ProfileFragment
import dagger.Subcomponent

@Subcomponent(modules = [ProfileModule::class])
interface ProfileComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ProfileComponent
    }

    fun inject(fragment: ProfileFragment)
}