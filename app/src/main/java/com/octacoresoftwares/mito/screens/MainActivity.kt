package com.octacoresoftwares.mito.screens

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.octacoresoftwares.core.base.BaseActivity
import com.octacoresoftwares.core.base.BaseViewModel
import com.octacoresoftwares.mito.R
import com.octacoresoftwares.mito.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : BaseActivity<ActivityMainBinding, BaseViewModel>(), ToolbarCallback {

    override fun getViewModel(): BaseViewModel? = null

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getViewModelBindingVariable(): Int = 0

    override fun getViewDataBinding(binding: ActivityMainBinding?) {
        if (binding != null) {
            this.binding = binding
        }
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.toolbar.setNavigationOnClickListener {
            if (binding.toolbar.navigationIcon != null) {
                onBackPressed()
            }
        }
    }

    override fun hideToolbar(value: Boolean) {
        if (value) {
            binding.toolbar.visibility = View.GONE
        } else {
            binding.toolbar.visibility = View.VISIBLE
        }
    }

    override fun displayNavigationIcon(value: Boolean) {
        if (value) {
            binding.toolbar.setNavigationIcon(R.drawable.ic_back)
        } else {
            binding.toolbar.navigationIcon = null
        }
    }

    override fun onBackPressed() {
        if (!onSupportNavigateUp())
            super.onBackPressed()
    }

    /*override fun onSupportNavigateUp(): Boolean {
        return if (appNavController().currentDestination?.id == R.id.navigation_main) {
            if (containerNavController().currentDestination?.id == R.id.navigation_dashboard) {
//                appNavController().navigate(ContainerFragmentDirections.actionNavigationMainToNavigationChooser())
                true
            } else {
                containerNavController().navigateUp() || super.onSupportNavigateUp()
            }
        } *//*else if (appNavController().currentDestination?.id == R.id.navigation_registration) {
            if (registrationNavController().currentDestination?.id == R.id.navigation_create_account) {
                appNavController().navigateUp()
                true
            } else {
                registrationNavController().navigateUp() || super.onSupportNavigateUp()
            }
        } else if (appNavController().currentDestination?.id == R.id.navigation_login) {
            appNavController().navigateUp()
        }*//* else {
            super.onSupportNavigateUp()
        }
    }*/

    private fun appNavController() = findNavController(R.id.app_host_fragment)

//    private fun containerNavController() = findNavController(R.id.container_host_fragment)

//    private fun registrationNavController() = findNavController(R.id.registration_container_host_fragment)
}

interface ToolbarCallback {
    fun hideToolbar(value: Boolean)
    fun displayNavigationIcon(value: Boolean)
}