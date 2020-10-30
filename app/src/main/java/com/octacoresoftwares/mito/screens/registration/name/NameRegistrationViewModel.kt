package com.octacoresoftwares.mito.screens.registration.name

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import com.octacoresoftwares.mito.BR
import com.octacoresoftwares.mito.repos.RegistrationRepository
import com.octacoresoftwares.mito.utils.ObservableViewModel
import javax.inject.Inject

class NameRegistrationViewModel @Inject constructor(private val repo: RegistrationRepository): ObservableViewModel() {

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