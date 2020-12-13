package com.octacoresoftwares.auth.viewmodels

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.octacoresoftwares.auth.BR
import com.octacoresoftwares.core.base.BaseViewModel
import com.octacoresoftwares.core.utils.isValidEmail
import com.octacoresoftwares.domain.ResultCallback
import com.octacoresoftwares.domain.interactors.auth.CreateAccountUpdateUsernameUseCase
import com.octacoresoftwares.domain.interactors.auth.CreateAccountUseCase
import com.octacoresoftwares.domain.interactors.auth.UpdateUsernameUseCase
import com.octacoresoftwares.domain.models.BaseDomainModel
import javax.inject.Inject

class CreateAccountViewModel @Inject constructor(
    private val createAccountUpdateUsernameUseCase: CreateAccountUpdateUsernameUseCase
) : BaseViewModel(){

    private val _createAccountResult = MutableLiveData<BaseDomainModel<*>>()
    val createAccountResult: LiveData<BaseDomainModel<*>> = _createAccountResult

    @get: Bindable
    var userName = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.userName)
            createAccountButtonEnabled = enableNameNextButton()
        }

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

            createAccountButtonEnabled = enableNameNextButton()
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

            createAccountButtonEnabled = enableNameNextButton()
        }

    @get: Bindable
    var confirmUserPassword = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.confirmUserPassword)

            if (field.isNotEmpty()) {
                if (field != userPassword) {
                    confirmPasswordErrorEnabled = true
                    confirmPasswordErrorText = "Password does not match"
                } else {
                    confirmPasswordErrorEnabled = false
                    confirmPasswordErrorText = ""
                }
            } else {
                confirmPasswordErrorEnabled = false
                confirmPasswordErrorText = ""
            }

            createAccountButtonEnabled = enableNameNextButton()
        }

    @get: Bindable
    var emailErrorEnabled = false
        private set(value) {
            field = value
            notifyPropertyChanged(BR.emailErrorEnabled)
        }

    @get: Bindable
    var emailErrorText = ""
        private set(value) {
            field = value
            notifyPropertyChanged(BR.emailErrorText)
        }

    @get: Bindable
    var passwordErrorEnabled = false
        private set(value) {
            field = value
            notifyPropertyChanged(BR.passwordErrorEnabled)
        }

    @get: Bindable
    var passwordErrorText = ""
        private set(value) {
            field = value
            notifyPropertyChanged(BR.passwordErrorText)
        }

    @get: Bindable
    var confirmPasswordErrorEnabled = false
        private set(value) {
            field = value
            notifyPropertyChanged(BR.confirmPasswordErrorEnabled)
        }

    @get: Bindable
    var confirmPasswordErrorText = ""
        private set(value) {
            field = value
            notifyPropertyChanged(BR.confirmPasswordErrorText)
        }

    @get: Bindable
    var layoutVisible = true
        private set(value) {
            field = value
            notifyPropertyChanged(BR.layoutVisible)
        }

    @get: Bindable
    var createAccountButtonEnabled = false
        private set(value) {
            field = value
            notifyPropertyChanged(BR.createAccountButtonEnabled)
        }

    fun createAccount() {
        createAccountUpdateUsernameUseCase.buildFirebaseTask(
            params = CreateAccountUpdateUsernameUseCase.Params(userEmail, userPassword, userName),
            callback = object : ResultCallback{
                override fun <R> result(r: R) {
                    _createAccountResult.postValue(r as BaseDomainModel<*>)
                }
            }
        )
    }

    private fun enableNameNextButton() =
        if (userName.isNotEmpty() && userEmail.isNotEmpty() && userPassword.isNotEmpty() && confirmUserPassword.isNotEmpty())
            !emailErrorEnabled && !passwordErrorEnabled && !confirmPasswordErrorEnabled
        else
            false
}