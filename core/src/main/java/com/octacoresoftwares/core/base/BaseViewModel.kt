package com.octacoresoftwares.core.base

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.octacoresoftwares.core.BR
import com.octacoresoftwares.core.models.LoggedInUser
import com.octacoresoftwares.core.utils.ObservableViewModel
import com.octacoresoftwares.domain.repository.IUserRepository
import javax.inject.Inject

open class BaseViewModel @Inject constructor() : ObservableViewModel() {

    @Inject
    lateinit var repo: IUserRepository

    @get: Bindable
    var toolbarVisible = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.toolbarVisible)
        }

    @get: Bindable
    var startSplashscreenAnimation = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.startSplashscreenAnimation)
        }

    fun signOutUser() {
        repo.signOut()
    }
}