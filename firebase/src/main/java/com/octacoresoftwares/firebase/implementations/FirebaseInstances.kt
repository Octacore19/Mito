package com.octacoresoftwares.firebase.implementations

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.octacoresoftwares.firebase.contracts.IFirebaseInstances
import javax.inject.Inject

class FirebaseInstances @Inject constructor() : IFirebaseInstances {

    override val firebaseAuth: FirebaseAuth
        get() = FirebaseAuth.getInstance()

    override val firebaseFireStore: FirebaseFirestore
        get() = FirebaseFirestore.getInstance()
}