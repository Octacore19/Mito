package com.octacoresoftwares.mito.screens.registration.name

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.google.firebase.Timestamp
import com.octacoresoftwares.mito.R
import com.octacoresoftwares.mito.databinding.FragmentNameRegistrationBinding
import com.octacoresoftwares.mito.models.User
import com.octacoresoftwares.mito.screens.container.RegistrationContainerFragment
import javax.inject.Inject

class NameRegistrationFragment : Fragment() {

    private val parentFragment by lazy {
        requireParentFragment().requireParentFragment() as RegistrationContainerFragment
    }

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    val viewModel by viewModels<NameRegistrationViewModel>({ parentFragment }) { factory }

    private lateinit var binding: FragmentNameRegistrationBinding

    private val args: NameRegistrationFragmentArgs by navArgs()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentFragment.registrationComponent.nameRegistrationComponent().create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_name_registration, container, false)
        binding = FragmentNameRegistrationBinding.bind(view)
        binding.vm = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args.user.let {
            viewModel.user = User(
                id = it.uid,
                userName = it.displayName!!,
                email = it.email!!
            )
        }

        viewModel.moveNameToNext.observe({ lifecycle }) { value ->
            if (value) {
                viewModel.user?.let {
                    val action =
                        NameRegistrationFragmentDirections.actionNavigationNameRegistrationToNavigationOtherInformation(
                            it
                        )
                    parentFragment.containerController.navigate(action)
                    viewModel.moveNameToNext.value = false
                }
            }
        }
    }
}