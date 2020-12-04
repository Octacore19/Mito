package com.octacoresoftwares.mito.screens.registration.contact.di

import androidx.lifecycle.ViewModel
import com.octacoresoftwares.mito.di.ViewModelKey
import com.octacoresoftwares.mito.screens.registration.contact.ContactRegistrationViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ContactRegistrationModule {

    @Binds
    @IntoMap
    @ViewModelKey(ContactRegistrationViewModel::class)
    abstract fun bindContactRegistrationViewModel(viewModel: ContactRegistrationViewModel): ViewModel
}