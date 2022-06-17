package com.hayde117.temi

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.hayde117.temi.databinding.FragmentAnimationBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class AnimationFragment : Fragment() {


    private var _binding: FragmentAnimationBinding? = null

    private val binding get() = _binding!!

    override fun onResume() {
        super.onResume()
//        val hash_algorithms = resources.getStringArray(R.array.hash_algorithms)
//        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.drop_down_item, hash_algorithms)
//        binding.autoCompleteTextView.setAdapter(arrayAdapter)

        lifecycleScope.launch {
            applyAnimations()
           // navigateToSuccess(getHashData())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAnimationBinding.inflate(inflater, container, false)


        return binding.root
    }

    private suspend fun applyAnimations() {
//        binding.generateButton.isClickable = false
//        binding.titleTextView.animate().alpha(0f).duration = 400L
//        binding.generateButton.animate().alpha(0f).duration = 400L
//        binding.textInputLayout.animate()
//            .alpha(0f).translationXBy(1200f)
//            .duration = 400L
//        binding.plainText.animate()
//            .alpha(0f).translationXBy(-1200f)
//            .duration = 400L
//
//        delay(300)

        binding.successBackground.animate().alpha(1f).duration = 600L
        binding.successBackground.animate().rotationBy(720f).duration = 600L
        binding.successBackground.animate().scaleXBy(900f).duration = 800L
        binding.successBackground.animate().scaleYBy(900f).duration = 800L

        delay(500)

        binding.successImageView.animate().alpha(1f).duration = 1000L

        delay(3000L)

//        val intent = Intent(this, DisplayActivity::class.java)
//        startActivity(intent)
        Handler().postDelayed( {
            val intent = Intent(requireContext(), DisplayActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }, 3000)

    }


}