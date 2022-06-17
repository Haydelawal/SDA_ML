package com.hayde117.temi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hayde117.temi.databinding.ActivityAnimationBinding

class AnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var binding: ActivityAnimationBinding

        super.onCreate(savedInstanceState)
        binding = ActivityAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)

      //  supportActionBar?.hide()

        supportActionBar?.hide()



    }
}