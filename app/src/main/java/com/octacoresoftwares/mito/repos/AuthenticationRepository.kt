package com.octacoresoftwares.mito.repos

import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.octacoresoftwares.core.models.Result
import com.octacoresoftwares.core.models.Result.Callback
import com.octacoresoftwares.core.models.User

interface LoginRepository {
    fun login(email: String, password: String, callback: Callback)
}

interface RegistrationRepository {
    fun register(email: String, password: String, callback: Callback)
    fun updateUsername(user: FirebaseUser, profileUpdate: UserProfileChangeRequest, callback: Callback)
    fun addUser(user: User, callback: Callback)
}