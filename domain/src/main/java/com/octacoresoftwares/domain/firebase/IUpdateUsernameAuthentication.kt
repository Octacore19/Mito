package com.octacoresoftwares.domain.firebase

import com.octacoresoftwares.domain.ResultCallback

interface IUpdateUsernameAuthentication {
    fun updateUsername(userName: String, callback: ResultCallback)
}