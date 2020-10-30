package com.octacoresoftwares.mito.screens.user.nearby

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class NearbyViewModel @Inject constructor() : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Nearby Fragment"
    }
    val text: LiveData<String> = _text
}