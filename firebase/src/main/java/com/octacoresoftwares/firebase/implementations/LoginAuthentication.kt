package com.octacoresoftwares.firebase.implementations

import com.octacoresoftwares.domain.ResultCallback
import com.octacoresoftwares.domain.firebase.ILoginAuthentication
import com.octacoresoftwares.domain.models.BaseDomainModel
import com.octacoresoftwares.domain.models.firebase.AuthUserModel
import com.octacoresoftwares.firebase.contracts.IFirebaseAuth
import javax.inject.Inject

class LoginAuthentication @Inject constructor(
    private val auth: IFirebaseAuth
) : ILoginAuthentication {

    override fun loginWithEmailAndPassword(
        email: String,
        password: String,
        callback: ResultCallback
    ) {
        auth.createAccountWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                it.user?.let { user ->
                    val userModel = AuthUserModel(
                        email = user.email,
                        userId = user.uid,
                        emailVerified = user.isEmailVerified
                    )
                    callback.result(
                        BaseDomainModel(
                            successful = true,
                            data = userModel,
                            message = "User successfully signed in"
                        )
                    )
                }
            }
            .addOnFailureListener {
                callback.result(
                    BaseDomainModel(
                        successful = false,
                        data = it,
                        message = "User failed to log in"
                    )
                )
            }
    }
}