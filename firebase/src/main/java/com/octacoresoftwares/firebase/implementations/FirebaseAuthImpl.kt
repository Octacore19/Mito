package com.octacoresoftwares.firebase.implementations

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.octacoresoftwares.firebase.contracts.IFirebaseAuth
import javax.inject.Inject

class FirebaseAuthImpl @Inject constructor(
    private val auth: FirebaseAuth
    ): IFirebaseAuth {

    override fun loginWithEmailAndPassword(email: String, password: String): Task<AuthResult> =
        auth.signInWithEmailAndPassword(email, password)

    override fun createAccountWithEmailAndPassword(email: String, password: String): Task<AuthResult> =
        auth.createUserWithEmailAndPassword(email, password)

    override fun updateUsername(username: String): Task<Void>? {
        val profileUpdate = UserProfileChangeRequest.Builder()
        profileUpdate.displayName = username
        val update = profileUpdate.build()
        val user = auth.currentUser
        return user?.updateProfile(update)
    }

    override fun signOut() {
        auth.signOut()
    }
}