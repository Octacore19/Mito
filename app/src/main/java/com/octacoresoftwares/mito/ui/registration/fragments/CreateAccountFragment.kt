package com.octacoresoftwares.mito.ui.registration.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.octacoresoftwares.mito.R
import com.octacoresoftwares.mito.databinding.FragmentCreateAccountBinding
import com.octacoresoftwares.mito.ui.registration.RegistrationContainerFragment
import com.octacoresoftwares.mito.ui.registration.RegistrationViewModel
import javax.inject.Inject

class CreateAccountFragment : Fragment() {

    private val parentFragment by lazy {
        requireParentFragment().requireParentFragment() as RegistrationContainerFragment
    }

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    val viewModel by viewModels<RegistrationViewModel>({ parentFragment }) { factory }

    private lateinit var binding: FragmentCreateAccountBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentFragment.registrationComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_create_account, container, false)
        binding = FragmentCreateAccountBinding.bind(view)
        binding.vm = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.moveNameToNext.observe({ lifecycle }) { value ->
            if (value) {
                viewModel.moveNameToNext.value = false
            }
        }
    }
}