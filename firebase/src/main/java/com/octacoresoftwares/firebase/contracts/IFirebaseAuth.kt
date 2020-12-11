package com.octacoresoftwares.firebase.contracts

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface IFirebaseAuth {
    fun loginWithEmailAndPassword(email: String, password: String): Task<AuthResult>
    fun createAccountWithEmailAndPassword(email: String, password: String): Task<AuthResult>
    fun updateUsername(username: String): Task<Void>?
    fun signOut()
}