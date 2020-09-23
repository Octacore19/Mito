package com.octacoresoftwares.mito.utils

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter(value = ["enableError", "errorText"], requireAll = true)
fun TextInputLayout.setErrorText(enabled: Boolean, text: String) {
    isErrorEnabled = enabled
    error = text
}

@BindingAdapter("setVisible")
fun ConstraintLayout.setVisible(visible: Boolean) {
    visibility = if (visible) {
        View.VISIBLE
    } else {
        View.INVISIBLE
    }
}