package com.example.bottombardrawernavvar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.bottombardrawernavvar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var actionBarDrawerTaggle: ActionBarDrawerToggle
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val navController = findNavController(R.id.fragmentContainerView)
        binding.bottomBar.setupWithNavController(navController)

        actionBarDrawerTaggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.nav_open, R.string.nav_close)
        actionBarDrawerTaggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.drawerNav.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.bmiCalc -> {
                    binding.drawerLayout.closeDrawers()
                    binding.drawerNav.setupWithNavController(navController)
                }
                R.id.unitConv ->{
                    binding.drawerLayout.closeDrawers()
                    binding.drawerNav.setupWithNavController(navController)
                }
                R.id.ageConv ->{
                    binding.drawerLayout.closeDrawers()
                    binding.drawerNav.setupWithNavController(navController)
                }
                R.id.logout ->{
                    binding.drawerLayout.closeDrawers()
                    binding.drawerNav.setupWithNavController(navController)
                }
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if(actionBarDrawerTaggle.onOptionsItemSelected(item)){
            true
        }
        else super.onOptionsItemSelected(item)
    }

}