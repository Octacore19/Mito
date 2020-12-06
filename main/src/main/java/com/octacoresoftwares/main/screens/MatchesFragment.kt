package com.octacoresoftwares.main.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.octacoresoftwares.main.R
import com.octacoresoftwares.main.databinding.FragmentMatchesBinding

class MatchesFragment: Fragment() {

    private lateinit var binding: FragmentMatchesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_matches, container, false)
        binding = FragmentMatchesBinding.bind(view)
        return binding.root
    }
}