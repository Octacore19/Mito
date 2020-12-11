package com.octacoresoftwares.domain.models.firebase

data class AuthUserModel(
    val userId: String,
    val email: String?,
    val displayName: String? = null,
    val phoneNumber: String? = null,
    val photoUrl: String? = null,
    val emailVerified: Boolean
)
