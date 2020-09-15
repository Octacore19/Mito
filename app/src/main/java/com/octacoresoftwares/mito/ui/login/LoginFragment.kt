package com.octacoresoftwares.mito.ui.login

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.octacoresoftwares.mito.MitoApplication
import com.octacoresoftwares.mito.R
import com.octacoresoftwares.mito.databinding.FragmentLoginBinding
import com.octacoresoftwares.mito.ui.profile.ProfileViewModel
import javax.inject.Inject

class LoginFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel by viewModels<LoginViewModel> { factory }
    lateinit var binding: FragmentLoginBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MitoApplication).appComponent.loginComponent().create().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        binding = FragmentLoginBinding.bind(view)
        binding.vm = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.success.observe({ lifecycle }) {
            if (it != null)
                Toast.makeText(requireContext(), "UserEmail: ${it.email}", Toast.LENGTH_SHORT).show()
        }

        viewModel.error.observe({ lifecycle }) {
            if (it != null)
                Toast.makeText(requireContext(), "Error: $it", Toast.LENGTH_SHORT).show()
        }
    }
}