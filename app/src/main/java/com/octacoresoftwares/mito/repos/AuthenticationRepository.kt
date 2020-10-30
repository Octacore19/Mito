package com.octacoresoftwares.mito.repos

import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.octacoresoftwares.mito.models.Result.Callback
import com.octacoresoftwares.mito.models.User

interface LoginRepository {
    fun login(email: String, password: String, callback: Callback)
}

interface RegistrationRepository {
    fun register(email: String, password: String, callback: Callback)
    fun updateUsername(user: FirebaseUser, profileUpdate: UserProfileChangeRequest, callback: Callback)
    fun addUser(user: User, callback: Callback)
}