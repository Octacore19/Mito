package com.octacoresoftwares.firebase.contracts

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser

interface IFirebaseAuth {
    fun loginWithEmailAndPassword(email: String, password: String): Task<AuthResult>
    fun createAccountWithEmailAndPassword(email: String, password: String): Task<AuthResult>
    fun updateUsername(username: String): Task<Void>?
    fun getCurrentUser(): FirebaseUser?
    fun signOut()
}