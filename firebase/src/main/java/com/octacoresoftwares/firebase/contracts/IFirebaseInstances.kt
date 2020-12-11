package com.octacoresoftwares.firebase.contracts

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

interface IFirebaseInstances {
    val firebaseAuth: FirebaseAuth
    val firebaseFireStore: FirebaseFirestore
}