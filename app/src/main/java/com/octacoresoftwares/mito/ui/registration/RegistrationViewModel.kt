package com.octacoresoftwares.mito.ui.registration

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.octacoresoftwares.mito.BR
import com.octacoresoftwares.mito.di.RegistrationScope
import com.octacoresoftwares.mito.models.Result
import com.octacoresoftwares.mito.models.Result.*
import com.octacoresoftwares.mito.repos.RegistrationRepository
import com.octacoresoftwares.mito.utils.ObservableViewModel
import com.octacoresoftwares.mito.utils.isValidEmail
import javax.inject.Inject

@RegistrationScope
class RegistrationViewModel @Inject constructor(private val repo: RegistrationRepository) :
    ObservableViewModel() {

    val moveNameToNext = MutableLiveData<Boolean>()

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

    /*@get: Bindable
    var userNameErrorEnabled = false
        private set(value) {
            field = value
            notifyPropertyChanged(BR.userNameErrorEnabled)
        }*/

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
    var firstName = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.firstName)
        }

    @get: Bindable
    var otherNames = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.otherNames)
        }

    @get: Bindable
    var lastName = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.lastName)
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

    fun moveNameToNext() {
        moveNameToNext.value = true
    }

    fun createAccount() {
        repo.register(userEmail.trim(), userPassword.trim(), object : Callback {
            override fun onSuccess(success: Success<Any>) {
                val user = success.data as FirebaseUser
                updateUserName(user)
            }

            override fun onError(error: Error) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun updateUserName(user: FirebaseUser) {
        val profileUpdate = userProfileChangeRequest {
            displayName = userName
        }
        repo.updateUsername(user, profileUpdate, object : Callback {
            override fun onSuccess(success: Success<Any>) {
                TODO("Not yet implemented")
            }

            override fun onError(error: Error) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun enableNameNextButton() =
        if (userName.isNotEmpty() && userEmail.isNotEmpty() && userPassword.isNotEmpty() && confirmUserPassword.isNotEmpty())
            !emailErrorEnabled && !passwordErrorEnabled && !confirmPasswordErrorEnabled
        else
            false
}