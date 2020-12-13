package com.octacoresoftwares.auth.di.screens.registration.create

import androidx.lifecycle.ViewModel
import com.octacoresoftwares.auth.viewmodels.CreateAccountViewModel
import com.octacoresoftwares.core.di.keys.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [CreateAccountUseCaseModule::class])
abstract class CreateAccountModule {

    @Binds
    @IntoMap
    @ViewModelKey(CreateAccountViewModel::class)
    abstract fun bindsCreateAccountViewModel(viewModel: CreateAccountViewModel): ViewModel
}