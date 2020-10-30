package com.octacoresoftwares.mito.screens.container

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.firebase.firestore.FirebaseFirestore
import com.octacoresoftwares.mito.MitoApplication
import com.octacoresoftwares.mito.R
import com.octacoresoftwares.mito.screens.registration.di.RegistrationComponent

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
                .create(FirebaseFirestore.getInstance())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_registration_container, container, false)

    override fun onResume() {
        super.onResume()
        val callback = requireActivity() as ToolbarCallback
        callback.hideToolbar(false)
        callback.displayNavigationIcon(true)
    }
}