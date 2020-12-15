package com.octacoresoftwares.auth.di.screens.registration.name

import com.octacoresoftwares.auth.screens.registration.NameRegistrationFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class NameRegistrationFragmentModule {

    @ContributesAndroidInjector(modules = [NameRegistrationModule::class])
    abstract fun bindsNameRegistrationFragment(): NameRegistrationFragment
}