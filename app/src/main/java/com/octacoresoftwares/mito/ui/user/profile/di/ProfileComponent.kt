package com.octacoresoftwares.mito.ui.user.profile.di

import com.octacoresoftwares.mito.ui.user.profile.ProfileFragment
import dagger.Subcomponent
import java.io.Serializable

@Subcomponent(modules = [ProfileModule::class])
interface ProfileComponent: Serializable {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ProfileComponent
    }

    fun inject(fragment: ProfileFragment)
}