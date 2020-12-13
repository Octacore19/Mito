package com.octacoresoftwares.nearby.di.modules

import androidx.lifecycle.ViewModel
import com.octacoresoftwares.core.di.keys.ViewModelKey
import com.octacoresoftwares.nearby.viewmodels.NearbyLandingViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class NearbyLandingModule {

    @Binds
    @IntoMap
    @ViewModelKey(NearbyLandingViewModel::class)
    abstract fun bindsNearbyLandingViewModel(viewModel: NearbyLandingViewModel): ViewModel
}