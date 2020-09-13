package com.octacoresoftwares.mito.ui.profile.di

import androidx.lifecycle.ViewModel
import com.octacoresoftwares.mito.di.ViewModelKey
import com.octacoresoftwares.mito.ui.profile.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ProfileModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(viewModel: ProfileViewModel): ViewModel
}