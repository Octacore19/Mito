package com.octacoresoftwares.mito.ui.registration.name.di

import androidx.lifecycle.ViewModel
import com.octacoresoftwares.mito.di.ViewModelKey
import com.octacoresoftwares.mito.ui.registration.name.NameRegistrationViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class NameRegistrationModule {

    @Binds
    @IntoMap
    @ViewModelKey(NameRegistrationViewModel::class)
    abstract fun bindNameRegistrationViewModel(viewModel: NameRegistrationViewModel): ViewModel
}