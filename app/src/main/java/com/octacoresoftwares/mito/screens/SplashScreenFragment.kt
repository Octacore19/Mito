package com.octacoresoftwares.mito.screens

import android.os.Handler
import android.os.Looper
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.octacoresoftwares.core.base.BaseFragment
import com.octacoresoftwares.core.base.BaseViewModel
import com.octacoresoftwares.mito.BR
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

    override fun getViewModelBindingVariable(): Int = BR.vm

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
}