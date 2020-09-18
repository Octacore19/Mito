package com.octacoresoftwares.mito.ui.login

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseUser
import com.octacoresoftwares.mito.BR
import com.octacoresoftwares.mito.models.Result.*
import com.octacoresoftwares.mito.repos.LoginRepository
import com.octacoresoftwares.mito.utils.ObservableViewModel
import com.octacoresoftwares.mito.utils.isValidEmail
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val repo: LoginRepository) :
    ObservableViewModel() {

    private val _success = MutableLiveData<FirebaseUser>()
    private val _error = MutableLiveData<Any>()
    val success: LiveData<FirebaseUser> = _success
    val error: LiveData<Any> = _error

    @get: Bindable
    var userEmail = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.userEmail)

            if (field.isNotEmpty()) {
                if (!isValidEmail(field)) {
                    emailErrorEnabled = true
                    emailErrorText = "Invalid Email"
                } else {
                    emailErrorEnabled = false
                    emailErrorText = ""
                }
            } else {
                emailErrorEnabled = false
                emailErrorText = ""
            }
        }

    @get: Bindable
    var userPassword = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.userPassword)

            if (field.isNotEmpty()) {
                if (field.length in 1..5) {
                    passwordErrorEnabled = true
                    passwordErrorText = "Password too short"
                } else {
                    passwordErrorEnabled = false
                    passwordErrorText = ""
                }
            } else {
                passwordErrorEnabled = false
                passwordErrorText = ""
            }
        }

    @get: Bindable
    var emailErrorText = ""
        private set(value) {
            field = value
            notifyPropertyChanged(BR.emailErrorText)
        }

    @get: Bindable
    var emailErrorEnabled = false
        private set(value) {
            field = value
            notifyPropertyChanged(BR.emailErrorEnabled)
        }

    @get: Bindable
    var passwordErrorText = ""
        private set(value) {
            field = value
            notifyPropertyChanged(BR.passwordErrorText)
        }

    @get: Bindable
    var passwordErrorEnabled = false
        private set(value) {
            field = value
            notifyPropertyChanged(BR.passwordErrorEnabled)
        }

    fun login() {
        when {
            userEmail.isEmpty() && userPassword.isEmpty() -> {
                emailErrorEnabled = true
                passwordErrorEnabled = true
                emailErrorText = "Field cannot be empty"
                passwordErrorText = "Field cannot be empty"
            }
            userEmail.isEmpty() -> {
                emailErrorEnabled = true
                emailErrorText = "Field cannot be empty"
            }
            userPassword.isEmpty() -> {
                passwordErrorEnabled = true
                passwordErrorText = "Field cannot be empty"
            }
            else -> {
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
    }
}