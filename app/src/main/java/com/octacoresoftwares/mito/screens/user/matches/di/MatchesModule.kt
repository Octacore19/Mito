package com.octacoresoftwares.mito.screens.user.matches.di

import androidx.lifecycle.ViewModel
import com.octacoresoftwares.mito.di.ViewModelKey
import com.octacoresoftwares.mito.screens.user.matches.MatchesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MatchesModule {

    @Binds
    @IntoMap
    @ViewModelKey(MatchesViewModel::class)
    abstract fun bindMatchesViewModel(viewModel: MatchesViewModel): ViewModel
}