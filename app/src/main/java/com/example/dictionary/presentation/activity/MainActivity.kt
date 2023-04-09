package com.example.dictionary.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.dictionary.R
import com.example.dictionary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigation()
    }

    private fun navigation() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu1 -> findNavController(R.id.navigation_fragment).navigate(R.id.home)
                R.id.menu2 -> findNavController(R.id.navigation_fragment).navigate(R.id.add)
                R.id.menu3 -> findNavController(R.id.navigation_fragment).navigate(R.id.training)
            }
            true
        }
    }

    fun navigateAction(res: Int) {
        binding.bottomNavigationView.selectedItemId = res
    }
}