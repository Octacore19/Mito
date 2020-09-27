package com.octacoresoftwares.mito.ui.container

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
import com.octacoresoftwares.mito.ui.user.di.DaggerUserComponent

class ContainerFragment : Fragment() {

    val userComponent by lazy {
        val component = (requireActivity().application as MitoApplication).appComponent
        DaggerUserComponent.factory().create(component)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_container, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = requireActivity().findNavController(R.id.container_host_fragment)
        val navView: BottomNavigationView = view.findViewById(R.id.nav_view)
        NavigationUI.setupWithNavController(navView, navController)
    }
}