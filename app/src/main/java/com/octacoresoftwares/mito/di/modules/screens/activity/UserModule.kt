package com.octacoresoftwares.mito.di.modules.screens.activity

import com.octacoresoftwares.domain.firebase.ICurrentAuthenticatedUser
import com.octacoresoftwares.domain.firebase.ISignOutAuthentication
import com.octacoresoftwares.firebase.implementations.CurrentAuthenticatedUser
import com.octacoresoftwares.firebase.implementations.SignOutAuthentication
import dagger.Binds
import dagger.Module

@Module
abstract class UserModule {


    @Binds
    abstract fun bindsCurrentAuthenticatedUser(auth: CurrentAuthenticatedUser): ICurrentAuthenticatedUser

    @Binds
    abstract fun bindsSignOutAuthentication(auth: SignOutAuthentication): ISignOutAuthentication
}