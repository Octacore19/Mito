package com.octacoresoftwares.mito.di.modules.repo

import com.octacoresoftwares.domain.repository.ILoginRepository
import com.octacoresoftwares.domain.repository.IRegistrationRepository
import com.octacoresoftwares.mito.di.modules.firebase.FirebaseAuthenticationModule
import com.octacoresoftwares.repo.IAuthenticationRepository
import com.octacoresoftwares.repo.implementations.AuthenticationRepository
import com.octacoresoftwares.repo.implementations.LoginRepository
import com.octacoresoftwares.repo.implementations.RegistrationRepository
import dagger.Binds
import dagger.Module

@Module(includes = [FirebaseAuthenticationModule::class])
abstract class AuthenticationRepositoryModule {

    @Binds
    abstract fun bindsAuthenticationRepository(repo: AuthenticationRepository): IAuthenticationRepository

    @Binds
    abstract fun bindsLoginRepository(repo: LoginRepository): ILoginRepository

    @Binds
    abstract fun bindsRegistrationRepository(repo: RegistrationRepository): IRegistrationRepository
}