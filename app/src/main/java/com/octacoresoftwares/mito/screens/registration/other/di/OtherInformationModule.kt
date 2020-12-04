package com.octacoresoftwares.mito.screens.registration.other.di

import androidx.lifecycle.ViewModel
import com.octacoresoftwares.mito.di.ViewModelKey
import com.octacoresoftwares.mito.screens.registration.other.OtherInformationViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class OtherInformationModule {

    @Binds
    @IntoMap
    @ViewModelKey(OtherInformationViewModel::class)
    abstract fun bindOtherInformationViewModel(viewModel: OtherInformationViewModel): ViewModel
}