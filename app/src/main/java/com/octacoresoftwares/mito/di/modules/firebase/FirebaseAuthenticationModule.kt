package com.octacoresoftwares.mito.di.modules.firebase

import com.octacoresoftwares.domain.firebase.ICreateAccountAuthentication
import com.octacoresoftwares.domain.firebase.ILoginAuthentication
import com.octacoresoftwares.domain.firebase.ISignOutAuthentication
import com.octacoresoftwares.domain.firebase.IUpdateUsernameAuthentication
import com.octacoresoftwares.firebase.implementations.CreateAccountAuthentication
import com.octacoresoftwares.firebase.implementations.LoginAuthentication
import com.octacoresoftwares.firebase.implementations.SignOutAuthentication
import com.octacoresoftwares.firebase.implementations.UpdateUsernameAuthentication
import dagger.Binds
import dagger.Module

@Module
abstract class FirebaseAuthenticationModule {

    @Binds
    abstract fun bindsCreateAccountAuth(auth: CreateAccountAuthentication): ICreateAccountAuthentication

    @Binds
    abstract fun bindsLoginAuthentication(auth: LoginAuthentication): ILoginAuthentication

    @Binds
    abstract fun bindsUpdateUserNameAuthentication(auth: UpdateUsernameAuthentication): IUpdateUsernameAuthentication
}