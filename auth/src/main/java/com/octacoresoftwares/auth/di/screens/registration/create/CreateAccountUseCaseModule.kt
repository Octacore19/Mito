package com.octacoresoftwares.auth.di.screens.registration.create

import com.octacoresoftwares.domain.interactors.auth.CreateAccountUpdateUsernameUseCase
import com.octacoresoftwares.domain.interactors.auth.CreateAccountUseCase
import com.octacoresoftwares.domain.interactors.auth.UpdateUsernameUseCase
import com.octacoresoftwares.domain.repository.IRegistrationRepository
import dagger.Module
import dagger.Provides

@Module
object CreateAccountUseCaseModule {

    @Provides
    fun provideCreateAccountUseCase(repo: IRegistrationRepository) = CreateAccountUseCase(repo)

    @Provides
    fun provideUpdateUsernameUseCase(repo: IRegistrationRepository) = UpdateUsernameUseCase(repo)

    @Provides
    fun provideCreateAccountUpdateUsernameUseCase(
        createAccountUseCase: CreateAccountUseCase,
        updateUsernameUseCase: UpdateUsernameUseCase
    ) = CreateAccountUpdateUsernameUseCase(createAccountUseCase, updateUsernameUseCase)
}