package com.octacoresoftwares.auth.di.screens.registration.host

import com.octacoresoftwares.auth.screens.registration.RegistrationHostFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class RegistrationFragmentHostModule {

    @ContributesAndroidInjector(modules = [RegistrationModule::class])
    abstract fun bindsRegistrationHostFragment(): RegistrationHostFragment
}