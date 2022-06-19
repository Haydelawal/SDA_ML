package com.hayde117.temi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.hayde117.temi.database.data.User
import com.hayde117.temi.database.data.UserViewModel
import com.hayde117.temi.databinding.ActivityDisplayBinding
import com.hayde117.temi.viewmodel.ActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*
import kotlin.math.roundToInt
import kotlin.time.Duration.Companion.milliseconds


@AndroidEntryPoint
class DisplayActivity : AppCompatActivity() {

    private  var _binding: ActivityDisplayBinding? = null

//    private lateinit var mUserViewModel: UserViewModel

    private val binding get() = _binding!!

    private val activityViewModel: ActivityViewModel by viewModels()


    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()


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

            binding.textView6.text = System.currentTimeMillis().toString()

            viewModel.addUser(user = User(0, it.name, my_val1, my_val2))

        })
    }


}