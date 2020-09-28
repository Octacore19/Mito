package com.octacoresoftwares.mito.repos

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.octacoresoftwares.mito.di.RegistrationScope
import com.octacoresoftwares.mito.models.Result.*
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private val auth: FirebaseAuth) : LoginRepository {

    override fun login(email: String, password: String, callback: Callback) {
        try {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val user = task.result?.user
                        if (user != null)
                            callback.onSuccess(Success(user))
                    } else {
                        val e = task.exception
                        if (e != null)
                            callback.onError(Error(e))
                    }
                }
        } catch (e: Exception) {
            callback.onError(Error(e))
        }
    }
}

@RegistrationScope
class RegistrationRepositoryImpl @Inject constructor(private val auth: FirebaseAuth) :
    RegistrationRepository {

    override fun register(email: String, password: String, callback: Callback) {
        try {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val user = task.result?.user
                        if (user != null)
                            callback.onSuccess(Success(user))
                    } else {
                        val e = task.exception
                        if (e != null)
                            callback.onError(Error(e))
                    }
                }
        } catch (e: Exception) {
            callback.onError(Error(e))
        }
    }

    override fun updateUsername(
        user: FirebaseUser,
        profileUpdate: UserProfileChangeRequest,
        callback: Callback
    ) {
        user.updateProfile(profileUpdate)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    callback.onSuccess(Success(0))
                } else {
                    val e = it.exception
                    if (e != null)
                        callback.onError(Error(e))
                }
            }
    }
}