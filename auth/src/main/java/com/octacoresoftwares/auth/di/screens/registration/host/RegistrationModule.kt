package com.octacoresoftwares.auth.di.screens.registration.host

import com.octacoresoftwares.core.navs.auth.RegistrationNav
import com.octacoresoftwares.domain.navigation.auth.IRegistrationNav
import com.octacoresoftwares.domain.repository.IRegistrationRepository
import com.octacoresoftwares.repo.implementations.RegistrationRepository
import dagger.Binds
import dagger.Module

@Module(includes = [ViewsModule::class])
abstract class RegistrationModule {

    @Binds
    abstract fun bindsRegistrationRepo(repo: RegistrationRepository): IRegistrationRepository

    @Binds
    abstract fun bindsNavRegistration(nav: RegistrationNav): IRegistrationNav
}