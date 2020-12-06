package com.octacoresoftwares.main.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.octacoresoftwares.main.R
import com.octacoresoftwares.main.databinding.FragmentNearbyBinding

class NearbyFragment : Fragment() {

    private lateinit var binding: FragmentNearbyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_nearby, container, false)
        binding = FragmentNearbyBinding.bind(view)
        return binding.root
    }
}