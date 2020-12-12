package com.octacoresoftwares.core.utils

import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.textfield.TextInputLayout
import com.octacoresoftwares.core.R

@BindingAdapter(value = ["enableError", "errorText"], requireAll = true)
fun TextInputLayout.setErrorText(enabled: Boolean, text: String) {
    isErrorEnabled = enabled
    error = text
}

@BindingAdapter("setVisible")
fun ConstraintLayout.setVisible(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.INVISIBLE
}

@BindingAdapter("displayNavigation")
fun MaterialToolbar.displayNavigation(visible: Boolean) {
    if (visible) {
        visibility = View.VISIBLE
        setNavigationIcon(R.drawable.ic_back)
    } else {
        visibility = View.GONE
    }
}

@BindingAdapter("animateView")
fun View.animateView(value: Boolean) {
    if (value) {
        val animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 2500
        animation.repeatCount = 1
        animation.repeatMode = Animation.REVERSE
        this.startAnimation(animation)
    }
}