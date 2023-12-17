package com.example.animewatcher.presentation.activites

import android.content.Context
import android.content.res.Configuration
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.animewatcher.R
import com.example.animewatcher.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigationrail.NavigationRailView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_main_activity)
        val bottomNavView: BottomNavigationView = binding.navView
        val RailNavView: NavigationRailView =  binding.navigationRail

        //BottomNavigation and RailNavigation
        bottomNavView.setupWithNavController(navController)
        RailNavView.setupWithNavController(navController)


        //Проверяет ориентацию устройства
        val isLandscape = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

        //ToolBar
        setSupportActionBar(binding.toolbar)
        binding.toolbar.isVisible = !isLandscape
        binding.toolbar.isVisible =
            !isLandscape && navController.currentDestination?.id != R.id.navigation_player

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_favorite, R.id.navigation_watch, R.id.navigation_release_date
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

        //Visibility bottomNav or RailNav
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_anime_info,R.id.navigation_player -> {
                    bottomNavView.isVisible = false
                    RailNavView.isVisible = false
                }
                R.id.navigation_search, R.id.navigation_settings -> {
                    bottomNavView.isVisible = false
                    RailNavView.isVisible = isLandscape
                }
                else -> {
                    bottomNavView.isVisible = !isLandscape
                    RailNavView.isVisible = isLandscape
                }

            }

        }


    }
    //Проверка на подключение к интернету 
    fun hasInternetConnection(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        return  capabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
    }

    //Стрелочка назад
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_main_activity)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    //ToolBar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       //TODO: надо доделать потом поиск и настройки
        menuInflater.inflate(R.menu.topbar_menu, menu)
        val search = menu!!.findItem(R.id.navigation_search)
        val settings = menu!!.findItem(R.id.navigation_settings)
        val navController = findNavController(R.id.nav_host_fragment_main_activity)
        return super.onCreateOptionsMenu(menu)
    }
}