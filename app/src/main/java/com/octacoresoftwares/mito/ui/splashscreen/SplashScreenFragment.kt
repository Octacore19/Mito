package com.octacoresoftwares.mito.ui.splashscreen

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


class SplashScreenFragment : Fragment() {

    private lateinit var icon: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_splash_screen, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        icon = view.findViewById(R.id.mito_logo)
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
        icon.startAnimation(animation)
    }
}