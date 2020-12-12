package com.octacoresoftwares.auth.viewmodels

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.octacoresoftwares.auth.BR
import com.octacoresoftwares.core.base.BaseViewModel
import com.octacoresoftwares.core.utils.isValidEmail
import com.octacoresoftwares.domain.ResultCallback
import com.octacoresoftwares.domain.interactors.LoginUseCase
import com.octacoresoftwares.domain.interactors.LoginUseCase.LoginParams
import com.octacoresoftwares.domain.models.BaseDomainModel
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : BaseViewModel() {

    private val _loginResult = MutableLiveData<BaseDomainModel<*>>()
    val loginResult: LiveData<BaseDomainModel<*>> = _loginResult

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
        loginUseCase.buildFirebaseTask(
            LoginParams(
                userEmail.trim(),
                userPassword.trim()
            ),
            object : ResultCallback {
                override fun <R> result(r: R) {
                    _loginResult.postValue(r as BaseDomainModel<*>)
                }
            })
    }

    private fun enableLoginButton() = if (userEmail.isNotEmpty() && userPassword.isNotEmpty()) {
        !passwordErrorEnabled && !emailErrorEnabled
    } else {
        false
    }
}