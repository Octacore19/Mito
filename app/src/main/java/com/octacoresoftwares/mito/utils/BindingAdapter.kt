package com.octacoresoftwares.mito.utils

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter(value = ["enableError", "errorText"], requireAll = true)
fun TextInputLayout.setErrorText(enabled: Boolean, text: String) {
    isErrorEnabled = enabled
    error = text
}