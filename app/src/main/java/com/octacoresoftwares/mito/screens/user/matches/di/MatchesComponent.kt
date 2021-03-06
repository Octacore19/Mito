package com.octacoresoftwares.mito.screens.user.matches.di

import com.octacoresoftwares.mito.screens.user.matches.MatchesFragment
import dagger.Subcomponent
import java.io.Serializable

@Subcomponent(modules = [MatchesModule::class])
interface MatchesComponent: Serializable {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MatchesComponent
    }

    fun inject(fragment: MatchesFragment)
}