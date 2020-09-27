package com.octacoresoftwares.mito.ui.user.profile

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.octacoresoftwares.mito.MitoApplication
import com.octacoresoftwares.mito.R
import com.octacoresoftwares.mito.databinding.FragmentProfileBinding
import com.octacoresoftwares.mito.ui.container.ContainerFragment
import javax.inject.Inject

class ProfileFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel by viewModels<ProfileViewModel> { factory }
    private lateinit var binding: FragmentProfileBinding

    private val parentFragment by lazy {
        requireParentFragment().requireParentFragment() as ContainerFragment
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentFragment.userManager.userComponent?.profileComponent()?.create()?.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        binding = FragmentProfileBinding.bind(view)
        binding.vm = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}