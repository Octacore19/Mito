package com.octacoresoftwares.auth.di.screens.registration.create

import com.octacoresoftwares.auth.screens.registration.CreateAccountFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class CreateAccountFragmentModule {

    @ContributesAndroidInjector(modules = [CreateAccountModule::class])
    abstract fun bindsCreateAccountFragment(): CreateAccountFragment
}