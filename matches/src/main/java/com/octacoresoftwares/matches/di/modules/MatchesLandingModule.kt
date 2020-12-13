package com.octacoresoftwares.matches.di.modules

import androidx.lifecycle.ViewModel
import com.octacoresoftwares.core.di.keys.ViewModelKey
import com.octacoresoftwares.matches.viewmodels.MatchesLandingViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MatchesLandingModule {

    @Binds
    @IntoMap
    @ViewModelKey(MatchesLandingViewModel::class)
    abstract fun bindsChatLandingViewModel(viewModel: MatchesLandingViewModel): ViewModel
}