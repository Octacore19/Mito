package com.octacoresoftwares.auth.di.screens.registration.name

import androidx.lifecycle.ViewModel
import com.octacoresoftwares.auth.viewmodels.NameRegistrationViewModel
import com.octacoresoftwares.core.di.keys.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class NameRegistrationModule {

    @Binds
    @IntoMap
    @ViewModelKey(NameRegistrationViewModel::class)
    abstract fun bindsNameRegistrationViewModel(viewModel: NameRegistrationViewModel): ViewModel
}