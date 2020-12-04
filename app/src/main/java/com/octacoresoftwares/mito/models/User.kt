package com.octacoresoftwares.mito.models

import com.google.firebase.Timestamp
import java.io.Serializable

data class User(
    val id: String? = null,
    val userName: String? = null,
    val email: String? = null,
    val createdAt: Timestamp? = null,
    val firstName: String? = null,
    val otherName: String? = null,
    val lastName: String? = null,
    val birthday: String? = null,
    val gender: String? = null,
    val country: String? = null,
    val profileImage: String? = null,
    val updatedAt: Timestamp? = null
): Serializable