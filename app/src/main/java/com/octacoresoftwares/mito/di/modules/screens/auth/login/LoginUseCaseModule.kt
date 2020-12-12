package com.octacoresoftwares.mito.di.modules.screens.auth.login

import com.octacoresoftwares.domain.interactors.LoginUseCase
import com.octacoresoftwares.domain.repository.ILoginRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
object LoginUseCaseModule {

    @Provides
    fun bindsLoginUseCase(auth: ILoginRepository) = LoginUseCase(auth)
}