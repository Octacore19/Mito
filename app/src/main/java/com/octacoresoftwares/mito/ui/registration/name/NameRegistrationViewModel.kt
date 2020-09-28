package com.octacoresoftwares.mito.ui.registration.name

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.octacoresoftwares.mito.BR
import com.octacoresoftwares.mito.utils.ObservableViewModel
import javax.inject.Inject

class NameRegistrationViewModel @Inject constructor(): ObservableViewModel() {

    val moveNameToNext = MutableLiveData<Boolean>()

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

    fun moveNameToNext() {
        moveNameToNext.value = true
    }
}