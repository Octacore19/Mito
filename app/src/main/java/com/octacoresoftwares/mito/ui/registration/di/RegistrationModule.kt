package com.octacoresoftwares.mito.ui.registration.di

import androidx.lifecycle.ViewModel
import com.octacoresoftwares.mito.di.RegistrationScope
import com.octacoresoftwares.mito.di.ViewModelKey
import com.octacoresoftwares.mito.repos.RegistrationRepository
import com.octacoresoftwares.mito.repos.RegistrationRepositoryImpl
import com.octacoresoftwares.mito.ui.registration.RegistrationViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class RegistrationModule {

    @Binds
    @IntoMap
    @RegistrationScope
    @ViewModelKey(RegistrationViewModel::class)
    abstract fun bindRegistrationViewModel(viewModel: RegistrationViewModel): ViewModel

    @Binds
    @RegistrationScope
    abstract fun bindRegistrationRepo(repo: RegistrationRepositoryImpl): RegistrationRepository
}