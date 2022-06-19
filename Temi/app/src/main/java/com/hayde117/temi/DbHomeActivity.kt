package com.hayde117.temi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.hayde117.temi.R
import com.hayde117.temi.databinding.ActivityAnimationBinding.inflate
import com.hayde117.temi.databinding.ActivityDbHomeBinding

class DbHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDbHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDbHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setupActionBarWithNavController(findNavController(R.id.nav_host_fragment))

    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment)
//        return navController.navigateUp() || super.onSupportNavigateUp()
//    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.db_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return true
    }




}