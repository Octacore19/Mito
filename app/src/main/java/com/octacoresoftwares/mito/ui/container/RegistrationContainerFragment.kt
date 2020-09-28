package com.octacoresoftwares.mito.ui.container

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.octacoresoftwares.mito.MitoApplication
import com.octacoresoftwares.mito.R
import com.octacoresoftwares.mito.ui.registration.di.RegistrationComponent
import javax.inject.Inject

class RegistrationContainerFragment : Fragment() {

    lateinit var registrationComponent: RegistrationComponent

    val appController by lazy {
        requireActivity().findNavController(R.id.app_host_fragment)
    }

    val containerController by lazy {
        requireActivity().findNavController(R.id.registration_container_host_fragment)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        registrationComponent =
            (requireActivity().application as MitoApplication).appComponent.registrationComponent()
                .create()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_registration_container, container, false)

}