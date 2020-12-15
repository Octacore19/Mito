package com.octacoresoftwares.domain.repository

import com.octacoresoftwares.domain.models.BaseDomainModel

interface IUserRepository {
    fun getCurrentUser(): BaseDomainModel<*>
    fun signOut()
}