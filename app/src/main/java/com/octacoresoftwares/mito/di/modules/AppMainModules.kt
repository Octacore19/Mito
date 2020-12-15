package com.octacoresoftwares.mito.di.modules

import android.content.Context
import com.octacoresoftwares.domain.firebase.ICurrentAuthenticatedUser
import com.octacoresoftwares.domain.repository.IUserRepository
import com.octacoresoftwares.firebase.contracts.IFirebaseAuth
import com.octacoresoftwares.firebase.contracts.IFirebaseFireStore
import com.octacoresoftwares.firebase.contracts.IFirebaseInstances
import com.octacoresoftwares.firebase.implementations.CurrentAuthenticatedUser
import com.octacoresoftwares.firebase.implementations.FirebaseAuthImpl
import com.octacoresoftwares.firebase.implementations.FirebaseFireStoreImpl
import com.octacoresoftwares.firebase.implementations.FirebaseInstances
import com.octacoresoftwares.mito.MitoApplication
import com.octacoresoftwares.mito.di.modules.screens.activity.MainActivityModules
import com.octacoresoftwares.repo.implementations.UserRepository
import dagger.Binds
import dagger.Module

@Module(includes = [MainActivityModules::class])
abstract class AppMainModules {

    @Binds
    abstract fun bindFirebaseInstances(instance: FirebaseInstances): IFirebaseInstances

    @Binds
    abstract fun bindsFirebaseAuth(auth: FirebaseAuthImpl): IFirebaseAuth

    @Binds
    abstract fun bindsFirebaseFirestore(firestore: FirebaseFireStoreImpl): IFirebaseFireStore

    @Binds
    abstract fun bindAppContext(app: MitoApplication): Context
}