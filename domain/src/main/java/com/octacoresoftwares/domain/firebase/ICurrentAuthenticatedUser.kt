package com.octacoresoftwares.domain.firebase

interface ICurrentAuthenticatedUser {
    fun getCurrentUser(): HashMap<String, Any?>
}