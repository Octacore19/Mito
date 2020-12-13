package com.octacoresoftwares.auth.di.repo

import com.octacoresoftwares.repo.IAuthenticationRepository
import com.octacoresoftwares.repo.implementations.AuthenticationRepository
import dagger.Binds
import dagger.Module

@Module
abstract class AuthenticationRepositoryModule {

    @Binds
    abstract fun bindsAuthenticationRepository(repo: AuthenticationRepository): IAuthenticationRepository
}