package com.octacoresoftwares.mito.di.modules.screens.activity

import androidx.lifecycle.ViewModel
import com.octacoresoftwares.core.base.BaseViewModel
import com.octacoresoftwares.core.di.keys.ViewModelKey
import com.octacoresoftwares.domain.repository.IUserRepository
import com.octacoresoftwares.mito.screens.AppViewModel
import com.octacoresoftwares.repo.implementations.UserRepository
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(BaseViewModel::class)
    abstract fun bindMainAppViewModel(viewModel: BaseViewModel): ViewModel

    @Binds
    abstract fun bindsUserRepository(repo: UserRepository): IUserRepository
}