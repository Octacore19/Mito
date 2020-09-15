package com.octacoresoftwares.mito.repos

import com.google.firebase.auth.FirebaseAuth
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

class RegistrationRepositoryImpl @Inject constructor(private val auth: FirebaseAuth) :
    RegistrationRepository {

    override fun register(email: String, password: String) {

    }

}