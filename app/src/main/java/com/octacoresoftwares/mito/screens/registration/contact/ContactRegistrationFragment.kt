package com.octacoresoftwares.mito.screens.registration.contact

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.octacoresoftwares.mito.R
import com.octacoresoftwares.mito.databinding.FragmentContactRegistrationBinding
import com.octacoresoftwares.mito.screens.container.RegistrationContainerFragment
import com.octacoresoftwares.mito.screens.registration.name.NameRegistrationViewModel
import javax.inject.Inject

class ContactRegistrationFragment : Fragment() {

    private val parentFragment by lazy {
        requireParentFragment().requireParentFragment() as RegistrationContainerFragment
    }

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    val viewModel by viewModels<ContactRegistrationViewModel>({ parentFragment }) { factory }

    private lateinit var binding: FragmentContactRegistrationBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentFragment.registrationComponent.contactRegistrationComponent().create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contact_registration, container, false)
        binding = FragmentContactRegistrationBinding.bind(view)
        binding.vm = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}