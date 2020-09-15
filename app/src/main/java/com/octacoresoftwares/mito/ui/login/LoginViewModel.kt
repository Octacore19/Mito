package com.octacoresoftwares.mito.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseUser
import com.octacoresoftwares.mito.models.Result.*
import com.octacoresoftwares.mito.repos.LoginRepository
import com.octacoresoftwares.mito.utils.ObservableViewModel
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val repo: LoginRepository) :
    ObservableViewModel() {

    var userEmail = ""
    var userPassword = ""

    private val _success = MutableLiveData<FirebaseUser>()
    private val _error = MutableLiveData<Any>()
    val success: LiveData<FirebaseUser> = _success
    val error: LiveData<Any> = _error

    fun login() {
        if (userEmail.isNotEmpty() && userPassword.isNotEmpty())
            repo.login(userEmail, userPassword, object : Callback {
                override fun onSuccess(success: Success<Any>) {
                    _success.value = success.data as FirebaseUser
                }

                override fun onError(error: Error) {
                    _error.value = error
                }
            })
    }
}