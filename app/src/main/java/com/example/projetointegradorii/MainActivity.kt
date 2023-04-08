package com.example.projetointegradorii

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.projetointegradorii.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val navController: NavController by lazy { findNavController(R.id.nav_host_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        customBar()
        setNavController()
        setNavigation()
    }

    private fun setNavController(){
        navController.navigateUp()
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.initialScreenFragment -> hideBottomNavigation()
                R.id.loginFragment -> hideBottomNavigation()
                R.id.registerFragment -> hideBottomNavigation()
                else -> showBottomNavigation()
            }
        }
    }

    private fun setNavigation(){
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_messages -> navController.navigate(R.id.messagesFragment)
                R.id.action_services -> navController.navigate(R.id.servicesFragment)
                R.id.action_contact -> navController.navigate(R.id.contactFragment)
                R.id.action_join_us -> navController.navigate(R.id.joinUsFragment)
                else -> false
            }
            true
        }
    }

    private fun showBottomNavigation() {
        binding.bottomNavigationView.visibility = View.VISIBLE
    }

    private fun hideBottomNavigation() {
        binding.bottomNavigationView.visibility = View.INVISIBLE
    }

    private fun customBar(){
        window.statusBarColor = Color.parseColor("#FFFFFFFF")

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.decorView.windowInsetsController?.setSystemBarsAppearance(APPEARANCE_LIGHT_STATUS_BARS, APPEARANCE_LIGHT_STATUS_BARS)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.navigationBarColor = getColor(R.color.dark_green)
        }
    }
}
