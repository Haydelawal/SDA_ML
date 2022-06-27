package com.hayde117.temi.database.fragments.view

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.hayde117.temi.R
import com.hayde117.temi.database.data.UserViewModel
import com.hayde117.temi.databinding.FragmentItemsBinding
import com.hayde117.temi.databinding.FragmentViewItemsBinding
import com.hayde117.temi.viewmodel.ActivityViewModel


class ViewItemsFragment : Fragment() {



    private val args by navArgs<ViewItemsFragmentArgs>()

//    private  lateinit  var binding: FragmentViewItemsBinding
//    private lateinit var mUserViewModel: UserViewModel

    private val mUserViewModel: UserViewModel by viewModels()


    private var _binding: FragmentViewItemsBinding? = null
    private val binding get() = _binding!!


//    private  var _mUserViewModel: UserViewModel? = null
//    private val mUserViewModel get() = _mUserViewModel!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentViewItemsBinding.inflate(inflater, container, false)

        binding.progressBar.progress = args.currentUser.first_percent
        binding.textViewProgress.text = args.currentUser.first_percent.toString()

        binding.progressBar2.progress = args.currentUser.second_percent
        binding.textViewProgress2.text = args.currentUser.second_percent.toString()



        binding.textValue.text = args.currentUser.message


        setHasOptionsMenu(true)


    return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_view, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.delete) {
            deleteUser()
        }



        return super.onOptionsItemSelected(item)
    }

    private fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") {_, _ ->
            mUserViewModel.deleteUser(user = args.currentUser)
            Toast.makeText(requireContext(), "Successfully Deleted From Database", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_viewItemsFragment_to_itemsFragment)
        }

        builder.setNegativeButton("NO"){_, _ -> }
        builder.setTitle("Delete This Saved Result?")
        builder.create().show()
    }
}