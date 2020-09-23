package com.octacoresoftwares.mito.ui.registration

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.octacoresoftwares.mito.MitoApplication
import com.octacoresoftwares.mito.R
import com.octacoresoftwares.mito.ui.registration.di.RegistrationComponent
import javax.inject.Inject

class RegistrationContainerFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    val viewModel by viewModels<RegistrationViewModel> { factory }

    private val args: RegistrationContainerFragmentArgs by navArgs()
    lateinit var registrationComponent: RegistrationComponent

    override fun onAttach(context: Context) {
        super.onAttach(context)
        registrationComponent =
            (requireActivity().application as MitoApplication).appComponent.registrationComponent()
                .create()
        registrationComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_registration_container, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val email = args.email
        if (email != null) {
            viewModel.userEmail = email
        }
    }
}