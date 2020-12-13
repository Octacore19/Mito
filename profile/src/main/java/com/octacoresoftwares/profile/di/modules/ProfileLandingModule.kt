package com.octacoresoftwares.profile.di.modules

import androidx.lifecycle.ViewModel
import com.octacoresoftwares.core.di.keys.ViewModelKey
import com.octacoresoftwares.profile.viewmodels.ProfileLandingViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ProfileLandingModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileLandingViewModel::class)
    abstract fun bindsProfileLandingViewModel(viewModel: ProfileLandingViewModel): ViewModel
}