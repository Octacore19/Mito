package com.octacoresoftwares.mito.ui.container

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
                appNavController().navigate(ContainerFragmentDirections.actionNavigationMainToNavigationChooser())
                true
            } else {
                containerNavController().navigateUp() || super.onSupportNavigateUp()
            }
        } else if (appNavController().currentDestination?.id == R.id.navigation_registration) {
            if (registrationNavController().currentDestination?.id == R.id.navigation_create_account) {
                appNavController().navigateUp()
                true
            } else {
                registrationNavController().navigateUp() || super.onSupportNavigateUp()
            }
        } else if (appNavController().currentDestination?.id == R.id.navigation_login) {
            appNavController().navigateUp()
        } else {
            super.onSupportNavigateUp()
        }
    }

    private fun appNavController() = findNavController(R.id.app_host_fragment)

    private fun containerNavController() = findNavController(R.id.container_host_fragment)

    private fun registrationNavController() = findNavController(R.id.registration_container_host_fragment)
}