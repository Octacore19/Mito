package com.octacoresoftwares.mito.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.octacoresoftwares.mito.R

class ContainerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_container, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHost = NavHostFragment()
        childFragmentManager.beginTransaction().replace(R.id.container_host_fragment, navHost).commitNow()
        navHost.navController.setGraph(R.navigation.container_navigation)

        val navView: BottomNavigationView = view.findViewById(R.id.nav_view)
        navView.setupWithNavController(navHost.navController)
    }
}