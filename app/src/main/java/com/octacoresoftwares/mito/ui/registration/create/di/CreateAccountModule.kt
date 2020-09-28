package com.octacoresoftwares.mito.ui.registration.create.di

import androidx.lifecycle.ViewModel
import com.octacoresoftwares.mito.di.ViewModelKey
import com.octacoresoftwares.mito.ui.registration.create.CreateAccountViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class CreateAccountModule {

    @Binds
    @IntoMap
    @ViewModelKey(CreateAccountViewModel::class)
    abstract fun bindCreateAccountViewModel(viewModel: CreateAccountViewModel): ViewModel
}