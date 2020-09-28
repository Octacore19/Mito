package com.octacoresoftwares.mito.ui.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.octacoresoftwares.mito.MitoApplication
import com.octacoresoftwares.mito.R
import com.octacoresoftwares.mito.databinding.FragmentLoginBinding
import com.octacoresoftwares.mito.ui.container.ToolbarCallback
import javax.inject.Inject

class LoginFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel by viewModels<LoginViewModel> { factory }
    lateinit var binding: FragmentLoginBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MitoApplication).appComponent.loginComponent().create()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        binding = FragmentLoginBinding.bind(view)
        binding.vm = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachObservers()
    }

    private fun attachObservers() {
        viewModel.success.observe({ lifecycle }) {
            if (it != null) {
                val action = LoginFragmentDirections.actionNavigationLoginToNavigationMain()
                requireActivity().findNavController(R.id.app_host_fragment).navigate(action)
                viewModel.success.value = null
            }
        }

        viewModel.error.observe({ lifecycle }) {
            if (it != null) {
                Toast.makeText(requireContext(), "Error: ${it.message}", Toast.LENGTH_LONG).show()
                viewModel.error.value = null
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val callback = requireActivity() as ToolbarCallback
        callback.hideToolbar(false)
    }
}