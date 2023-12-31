package com.example.bottombardrawernavvar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.bottombardrawernavvar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var weightTxt: EditText
    private lateinit var heightTxt: EditText
    private lateinit var calBtn: Button
    private lateinit var countTxt: TextView
    private lateinit var resultTxt: TextView
    private lateinit var rangeTxt: TextView

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

        weightTxt = findViewById(R.id.weightEt)
        heightTxt = findViewById(R.id.hightEt)
        calBtn = findViewById(R.id.calBtn)
        countTxt = findViewById(R.id.countTxt)
        resultTxt = findViewById(R.id.resultTxt)
        rangeTxt = findViewById(R.id.rangeTxt)

        calBtn.setOnClickListener {
            val weight = weightTxt.text.toString()
            val height = heightTxt.text.toString()

            val bmi = weight.toFloat() / (height.toFloat() * height.toFloat()/10000)

            val bmiDigit = String.format("%.2f", bmi).toFloat()

            displayResult(bmiDigit)
        }
    }


    private fun displayResult(bmi: Float) {
        countTxt.text = bmi.toString()
        resultTxt.text = "Health is Wealth"
        rangeTxt.text = "(Normal range is 18.5-24.5)"

        var result = ""
        var color = 0
        var range = ""

        when {
            bmi < 18.50 -> {
                result = "Underweight"
                range = "(Underweight range is less than 18.50)"
            }

            bmi in 18.50..24.99 -> {
                result = "Healthy"
                range = "(Healthy range is 18.50-24.99)"
            }

            bmi in 25.00..29.99 -> {
                result = "Overweight"
                range = "(Overweight range is 24.99-29.99)"
            }

            bmi > 29.99 -> {
                result = "Obese"
                range = "(Obese range is greater than 29.99)"
            }
        }
        resultTxt.text = result
        rangeTxt.text = range
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if(actionBarDrawerTaggle.onOptionsItemSelected(item)){
            true
        }
        else super.onOptionsItemSelected(item)
    }

}