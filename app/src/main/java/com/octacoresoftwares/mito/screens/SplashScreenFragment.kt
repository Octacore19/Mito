package com.octacoresoftwares.mito.screens

import android.os.Handler
import android.os.Looper
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.octacoresoftwares.auth.BR
import com.octacoresoftwares.core.base.BaseFragment
import com.octacoresoftwares.core.base.BaseViewModel
import com.octacoresoftwares.mito.R
import com.octacoresoftwares.mito.databinding.FragmentSplashScreenBinding
import javax.inject.Inject


class SplashScreenFragment : BaseFragment<FragmentSplashScreenBinding, BaseViewModel>() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val model by viewModels<BaseViewModel> { factory }

    private lateinit var binding: FragmentSplashScreenBinding

    override fun getViewModel(): BaseViewModel = model

    override fun getLayoutId(): Int = R.layout.fragment_splash_screen

    override fun getViewModelBindingVariable(): Int = 0

    override fun setViewDataBinding(binding: FragmentSplashScreenBinding?) {
        binding?.let {
            this.binding = it
        }
    }

    override fun onStart() {
        super.onStart()
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(SplashScreenFragmentDirections.actionNavigationSplashScreenToNavigationAuthentication())
        }, 5000L)
        model.startSplashscreenAnimation = true
    }

    /*private fun fadeIn() {
        val animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 2500
        animation.repeatCount = 1
        animation.repeatMode = Animation.REVERSE
        binding.mitoLogo.startAnimation(animation)
    }*/
}