package com.octacoresoftwares.mito.ui.matches.di

import com.octacoresoftwares.mito.ui.matches.MatchesFragment
import dagger.Subcomponent

@Subcomponent(modules = [MatchesModule::class])
interface MatchesComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MatchesComponent
    }

    fun inject(fragment: MatchesFragment)
}