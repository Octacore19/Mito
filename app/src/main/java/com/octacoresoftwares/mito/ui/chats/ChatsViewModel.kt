package com.octacoresoftwares.mito.ui.chats

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class ChatsViewModel @Inject constructor() : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Chats Fragment"
    }
    val text: LiveData<String> = _text
}