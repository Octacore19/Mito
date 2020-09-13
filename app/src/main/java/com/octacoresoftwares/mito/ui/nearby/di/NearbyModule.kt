package com.octacoresoftwares.mito.ui.nearby.di

import androidx.lifecycle.ViewModel
import com.octacoresoftwares.mito.di.ViewModelKey
import com.octacoresoftwares.mito.ui.nearby.NearbyViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class NearbyModule {

    @Binds
    @IntoMap
    @ViewModelKey(NearbyViewModel::class)
    abstract fun bindNearbyViewModel(viewModel: NearbyViewModel): ViewModel
}