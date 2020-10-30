package com.octacoresoftwares.mito.screens.user

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.octacoresoftwares.mito.screens.user.di.UserComponent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserManager @Inject constructor(
    private val auth: FirebaseAuth,
    private val userComponentFactory: UserComponent.Factory
) {
    var currentUser: FirebaseUser? = null
    var userComponent: UserComponent? = null

    private lateinit var authStateListener: FirebaseAuth.AuthStateListener
    private lateinit var idTokenListener: FirebaseAuth.IdTokenListener

    fun isUserLoggedIn() = userComponent != null

    fun initManager() {
        currentUser = auth.currentUser
        if (currentUser != null) {
            userCurrentlyLoggedIn()
        }

        initListeners()
    }

    fun registerListeners() {
        auth.addAuthStateListener(authStateListener)
        auth.addIdTokenListener(idTokenListener)
    }

    fun removeListeners() {
        auth.removeAuthStateListener(authStateListener)
        auth.removeIdTokenListener(idTokenListener)
    }

    fun logUserOut() {
        auth.signOut()
        userComponent = null
    }

    private fun initListeners() {
        authStateListener = FirebaseAuth.AuthStateListener {
            val user = it.currentUser
            if (user != null) {
                currentUser = user
                userCurrentlyLoggedIn()
            } else {
                logUserOut()
            }
        }

        idTokenListener = FirebaseAuth.IdTokenListener {
            val user = it.currentUser
            if (user != null) {
                currentUser = user
                userCurrentlyLoggedIn()
            } else {
                logUserOut()
            }
        }
    }

    private fun userCurrentlyLoggedIn() {
        userComponent = userComponentFactory.create(FirebaseFirestore.getInstance())
    }
}