package com.octacoresoftwares.mito.screens.login

import androidx.databinding.Bindable
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

    val success = MutableLiveData<FirebaseUser>()
    val error = MutableLiveData<Exception>()

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

            buttonEnabled = enableLoginButton()
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

            buttonEnabled = enableLoginButton()
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

    @get: Bindable
    var buttonEnabled = false
        private set(value) {
            field = value
            notifyPropertyChanged(BR.buttonEnabled)
        }

    fun login() {

        repo.login(userEmail.trim(), userPassword.trim(), object : Callback {
            override fun onSuccess(success: Success<Any>) {
                this@LoginViewModel.success.value = success.data as FirebaseUser
            }

            override fun onError(error: Error) {
                this@LoginViewModel.error.value = error.exception
            }
        })
    }

    private fun enableLoginButton() = if (userEmail.isNotEmpty() && userPassword.isNotEmpty()) {
        !passwordErrorEnabled && !emailErrorEnabled
    } else {
        false
    }
}