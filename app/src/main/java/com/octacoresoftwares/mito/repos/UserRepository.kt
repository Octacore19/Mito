package com.octacoresoftwares.mito.repos

import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class UserRepository @Inject constructor(private val auth: FirebaseAuth) {

}