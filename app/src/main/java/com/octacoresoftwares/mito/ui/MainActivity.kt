package com.octacoresoftwares.mito.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.octacoresoftwares.mito.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        if (!onSupportNavigateUp())
            super.onBackPressed()
    }

    override fun onSupportNavigateUp(): Boolean {
        return if (appNavController().currentDestination?.id == R.id.navigation_main) {
            if (containerNavController().currentDestination?.id == R.id.navigation_dashboard) {
                appNavController().navigate(ContainerFragmentDirections.actionNavigationMainToNavigationLogin())
                true
            } else {
                containerNavController().navigateUp()
            }
        } else
            super.onSupportNavigateUp()
    }

    private fun appNavController() = findNavController(R.id.app_host_fragment)

    private fun containerNavController() = findNavController(R.id.container_host_fragment)
}