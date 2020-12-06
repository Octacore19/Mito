package com.octacoresoftwares.auth.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.octacoresoftwares.auth.R
import com.octacoresoftwares.auth.databinding.FragmentRegistrationHostBinding

class RegistrationHostFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationHostBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_registration_host, container, false)
        binding = FragmentRegistrationHostBinding.bind(view)
        return binding.root
    }
}