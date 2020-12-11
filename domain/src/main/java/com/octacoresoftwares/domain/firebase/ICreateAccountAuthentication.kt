package com.octacoresoftwares.domain.firebase

import com.octacoresoftwares.domain.ResultCallback

interface ICreateAccountAuthentication {
    fun createAccountWithEmailAndPassword(email: String, password: String, callback: ResultCallback)
}