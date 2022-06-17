package com.hayde117.temi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hayde117.temi.databinding.ActivityDisplayBinding
import com.hayde117.temi.viewmodel.ActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*
import kotlin.math.roundToInt


@AndroidEntryPoint
class DisplayActivity : AppCompatActivity() {

    private  var _binding: ActivityDisplayBinding? = null

    private val binding get() = _binding!!

    private val activityViewModel: ActivityViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()




//        var spam_value = 0
//        var spam_value2 = 0

        val viewModel = ViewModelProvider(this).get(ActivityViewModel::class.java)
        viewModel.retrieveDate()

        viewModel.showTheData().observe(this, Observer {
            var str : String = it.phone
            var str2 : String  = it.address



            var num : Double = str.toDouble()
            var num2 : Double = str2.toDouble()

            var final : Double = num * 100
            var final2 : Double = num2 * 100

           var my_val1 = final.roundToInt()
            var my_val2 = final2.roundToInt()



            binding.textViewProgress.text = my_val1.toString()
            binding.textViewProgress2.text = my_val2.toString()

            binding.progressBar.progress = my_val1
            binding.progressBar2.progress = my_val2
            binding.textValue.text = it.name





        })


    }

}