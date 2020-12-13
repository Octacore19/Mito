package com.octacoresoftwares.auth.viewmodels

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import com.octacoresoftwares.core.base.BaseViewModel
import javax.inject.Inject

class NameRegistrationViewModel @Inject constructor(): BaseViewModel() {

    val moveNameToNext = MutableLiveData<Boolean>()
//    var user: User? = null

    @get: Bindable
    var firstName = ""
        set(value) {
            field = value
//            notifyPropertyChanged(BR.firstName)
        }

    @get: Bindable
    var otherNames = ""
        set(value) {
            field = value
//            notifyPropertyChanged(BR.otherNames)
        }

    @get: Bindable
    var lastName = ""
        set(value) {
            field = value
//            notifyPropertyChanged(BR.lastName)
        }

    fun moveNameToNext() {
        moveNameToNext.value = true
    }
}