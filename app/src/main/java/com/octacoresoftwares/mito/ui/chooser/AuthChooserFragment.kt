package com.octacoresoftwares.mito.ui.chooser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.octacoresoftwares.mito.R
import com.octacoresoftwares.mito.databinding.FragmentAuthChooserBinding

class AuthChooserFragment : Fragment() {

    private lateinit var binding: FragmentAuthChooserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_auth_chooser, container, false)
        binding = FragmentAuthChooserBinding.bind(view)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener {
            val action = AuthChooserFragmentDirections.actionNavigationChooserToNavigationLogin()
            findNavController().navigate(action)
        }

        binding.getStartedButton.setOnClickListener {
            val action = AuthChooserFragmentDirections.actionNavigationChooserToNavigationRegistration(null)
            findNavController().navigate(action)
        }
    }
}