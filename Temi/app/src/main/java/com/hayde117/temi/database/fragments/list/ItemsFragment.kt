package com.hayde117.temi.database.fragments.list

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.hayde117.temi.R
import com.hayde117.temi.database.data.UserViewModel
import com.hayde117.temi.databinding.FragmentItemsBinding
import com.hayde117.temi.viewmodel.ActivityViewModel


class ItemsFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    private  var _binding: FragmentItemsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_items, container, false)

        _binding = FragmentItemsBinding.inflate(inflater, container, false)

        // RecyclerView
        val adapter = ListAdapter()

        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //UseViewModel
         mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            adapter.setData(user)
        })



//        setHasOptionsMenu(true)

        return binding.root

    }



}