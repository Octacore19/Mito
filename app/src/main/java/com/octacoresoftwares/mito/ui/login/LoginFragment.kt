package com.octacoresoftwares.mito.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.octacoresoftwares.mito.R
import com.octacoresoftwares.mito.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        binding = FragmentLoginBinding.bind(view)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.content.loginButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionNavigationLoginToNavigationMain())
        }
    }
}