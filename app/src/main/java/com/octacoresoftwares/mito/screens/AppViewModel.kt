package com.octacoresoftwares.mito.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.octacoresoftwares.core.base.BaseViewModel
import com.octacoresoftwares.core.models.LoggedInUser
import com.octacoresoftwares.core.utils.AppLog
import com.octacoresoftwares.domain.repository.IUserRepository
import com.octacoresoftwares.repo.implementations.UserRepository
import javax.inject.Inject

class AppViewModel @Inject constructor() : BaseViewModel() {

    private val _currentUser = MutableLiveData<LoggedInUser?>()
    val currentUser: LiveData<LoggedInUser?> = _currentUser

    fun getCurrentUser() {
        repo.getCurrentUser().let {
            AppLog.d("Result: $it")
            if (it.successful) {
                val user = it.data as HashMap<*, *>
                _currentUser.postValue(
                    LoggedInUser(
                        username = user["displayName"] as String?,
                        email = user["email"] as String?
                    )
                )
            } else {
                _currentUser.postValue(null)
            }
        }
    }
}