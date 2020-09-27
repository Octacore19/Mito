package com.octacoresoftwares.mito.ui.user.matches

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MatchesViewModel @Inject constructor() : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Matches Fragment"
    }
    val text: LiveData<String> = _text
}