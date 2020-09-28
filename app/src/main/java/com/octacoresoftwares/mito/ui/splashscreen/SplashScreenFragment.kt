package com.octacoresoftwares.mito.ui.splashscreen

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.octacoresoftwares.mito.R
import com.octacoresoftwares.mito.databinding.FragmentSplashScreenBinding
import com.octacoresoftwares.mito.ui.container.ToolbarCallback


class SplashScreenFragment : Fragment() {

    private lateinit var binding: FragmentSplashScreenBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback = requireActivity() as ToolbarCallback
        callback.hideToolbar(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_splash_screen, container, false)
        binding = FragmentSplashScreenBinding.bind(view)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(SplashScreenFragmentDirections.actionNavigationSplashScreenToNavigationMain())
        }, 5000L)
        fadeIn()
    }

    private fun fadeIn(){
        val animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 2500
        animation.repeatCount = 1
        animation.repeatMode = Animation.REVERSE
        binding.mitoLogo.startAnimation(animation)
    }
}