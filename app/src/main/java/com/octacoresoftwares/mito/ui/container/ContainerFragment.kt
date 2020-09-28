package com.octacoresoftwares.mito.ui.container

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.octacoresoftwares.mito.MitoApplication
import com.octacoresoftwares.mito.R
import com.octacoresoftwares.mito.ui.user.UserManager

class ContainerFragment : Fragment() {

    lateinit var userManager: UserManager

    val appController by lazy {
        requireActivity().findNavController(R.id.app_host_fragment)
    }

    val containerController by lazy {
        requireActivity().findNavController(R.id.container_host_fragment)
    }

    override fun onAttach(context: Context) {
        userManager = (requireActivity().application as MitoApplication).appComponent.userManager()
        userManager.initManager()
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = if (!userManager.isUserLoggedIn()) {
        val action = ContainerFragmentDirections.actionNavigationMainToNavigationChooser()
        appController.navigate(action)
        null
    } else {
        inflater.inflate(R.layout.fragment_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navView: BottomNavigationView = view.findViewById(R.id.nav_view)
        NavigationUI.setupWithNavController(navView, containerController)
    }

    override fun onResume() {
        super.onResume()
        val callback = requireActivity() as ToolbarCallback
        callback.hideToolbar(true)

        userManager.registerListeners()
    }

    override fun onPause() {
        userManager.removeListeners()
        super.onPause()
    }

    override fun onDetach() {
        userManager.logUserOut()
        super.onDetach()
    }
}