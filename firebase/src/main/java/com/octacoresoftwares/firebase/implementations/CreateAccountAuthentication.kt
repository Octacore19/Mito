package com.octacoresoftwares.firebase.implementations

import com.octacoresoftwares.domain.ResultCallback
import com.octacoresoftwares.domain.firebase.ICreateAccountAuthentication
import com.octacoresoftwares.domain.models.BaseDomainModel
import com.octacoresoftwares.firebase.contracts.IFirebaseAuth
import javax.inject.Inject

class CreateAccountAuthentication @Inject constructor(
    private val auth: IFirebaseAuth
): ICreateAccountAuthentication {
    override fun createAccountWithEmailAndPassword(email: String, password: String, callback: ResultCallback) {
        auth.createAccountWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                callback.result(
                    BaseDomainModel(
                        successful = true,
                        data = it.user,
                        message = "Successfully created an account"
                    )
                )
            }
            .addOnFailureListener {
                callback.result(
                    BaseDomainModel(
                        successful = false,
                        data = it,
                        message = "Failed to create an account"
                    )
                )
            }
    }
}