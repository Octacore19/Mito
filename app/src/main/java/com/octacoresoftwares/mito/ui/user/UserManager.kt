package com.octacoresoftwares.mito.ui.user

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.octacoresoftwares.mito.ui.user.di.UserComponent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserManager @Inject constructor(
    private val auth: FirebaseAuth,
    private val userComponentFactory: UserComponent.Factory
) {
    val currentUser: FirebaseUser?
        get() = auth.currentUser

    val userComponent: UserComponent?
        get() {
            return if (currentUser != null) {
                userComponentFactory.create()
            } else null
        }

    fun isUserLoggedIn() = userComponent != null

    fun logUserOut() {
        auth.signOut()
    }
}