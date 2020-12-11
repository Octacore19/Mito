package com.octacoresoftwares.domain.firebase

import com.octacoresoftwares.domain.ResultCallback

interface ILoginAuthentication {
    fun loginWithEmailAndPassword(email: String, password: String, callback: ResultCallback)
}