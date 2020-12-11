package com.octacoresoftwares.mito.di.modules.firebase

import com.octacoresoftwares.firebase.implementations.FirebaseInstances
import dagger.Module
import dagger.Provides

@Module
object FirebaseInstanceModules {

    @Provides
    fun provideFirebaseAuthInstance(instance: FirebaseInstances) = instance.firebaseAuth

    @Provides
    fun provideFirestoreInstance(instance: FirebaseInstances) = instance.firebaseFireStore
}