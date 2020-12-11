package com.octacoresoftwares.firebase.implementations

import com.google.android.gms.tasks.Task
import com.octacoresoftwares.domain.ResultCallback
import com.octacoresoftwares.domain.firebase.IUpdateUsernameAuthentication
import com.octacoresoftwares.domain.models.BaseDomainModel
import com.octacoresoftwares.firebase.contracts.IFirebaseAuth
import javax.inject.Inject

class UpdateUsernameAuthentication @Inject constructor(
    private val auth: IFirebaseAuth
): IUpdateUsernameAuthentication {

    override fun updateUsername(userName: String, callback: ResultCallback) {
        auth.updateUsername(userName)?.addOnSuccessListener {
                callback.result(
                    BaseDomainModel(
                        successful = true,
                        data = it,
                        message = "Username successfully updated"
                    )
                )
            }?.addOnFailureListener {
                callback.result(
                    BaseDomainModel(
                        successful = false,
                        data = it,
                        message = "Failed to updated username"
                    )
                )
        }
    }
}