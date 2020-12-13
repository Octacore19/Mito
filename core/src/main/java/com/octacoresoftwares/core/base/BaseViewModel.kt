package com.octacoresoftwares.core.base

import androidx.databinding.Bindable
import com.octacoresoftwares.core.BR
import com.octacoresoftwares.core.utils.ObservableViewModel
import javax.inject.Inject

open class BaseViewModel @Inject constructor(): ObservableViewModel() {

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
}