package com.octacoresoftwares.mito.utils

import com.google.firebase.firestore.FieldPath
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.octacoresoftwares.mito.models.Result
import com.octacoresoftwares.mito.models.Result.Callback
import com.octacoresoftwares.mito.models.User
import javax.inject.Inject


class UserRegistrationManager @Inject constructor(private val db: FirebaseFirestore) {

    fun addNewUser(user: User, callback: Callback) {
        db.collection(USERS_COLLECTION)
            .document(user.id!!)
            .set(user)
            .addOnSuccessListener {
                callback.onSuccess(Result.Success(it))
            }
            .addOnFailureListener {
                callback.onError(Result.Error(it))
            }
    }
}

class UserActivitiesManager @Inject constructor(private val db: FirebaseFirestore) {
    lateinit var mQuery: Query

    fun initDb(user: User) {
        mQuery = db.collection(USERS_COLLECTION).whereEqualTo(FieldPath.documentId(), user.id)
    }
}

private const val USERS_COLLECTION = "users"