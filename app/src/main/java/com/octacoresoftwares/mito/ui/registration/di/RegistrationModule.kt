package com.octacoresoftwares.mito.ui.registration.di

import com.octacoresoftwares.mito.di.RegistrationScope
import com.octacoresoftwares.mito.repos.RegistrationRepository
import com.octacoresoftwares.mito.repos.RegistrationRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RegistrationModule {

    @Binds
    @RegistrationScope
    abstract fun bindRegistrationRepo(repo: RegistrationRepositoryImpl): RegistrationRepository
}