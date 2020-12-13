package com.octacoresoftwares.auth.di.screens.login

import com.octacoresoftwares.domain.interactors.auth.LoginUseCase
import com.octacoresoftwares.domain.repository.ILoginRepository
import dagger.Module
import dagger.Provides

@Module
object LoginUseCaseModule {

    @Provides
    fun providesLoginUseCase(auth: ILoginRepository) = LoginUseCase(auth)
}