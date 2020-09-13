package com.octacoresoftwares.mito.ui

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.octacoresoftwares.mito.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        if(!onSupportNavigateUp())
            super.onBackPressed()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController().navigateUp() || super.onSupportNavigateUp()
    }

    private fun navController(): NavController
        = findNavController(R.id.container_host_fragment)
}