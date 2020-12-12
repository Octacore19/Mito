package com.octacoresoftwares.mito.di.modules.repo

import com.octacoresoftwares.mito.di.modules.firebase.FirebaseAuthenticationModule
import com.octacoresoftwares.repo.IAuthenticationRepository
import com.octacoresoftwares.repo.implementations.AuthenticationRepository
import dagger.Binds
import dagger.Module

@Module(includes = [FirebaseAuthenticationModule::class])
abstract class AuthenticationRepositoryModule {

    @Binds
    abstract fun bindsAuthenticationRepository(repo: AuthenticationRepository): IAuthenticationRepository
}