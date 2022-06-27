package com.hayde117.temi.database.fragments.list

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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


class ItemsFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var mUserViewModel: UserViewModel

    private var _binding: FragmentItemsBinding? = null
    private val binding get() = _binding!!

//    private val myAdapter: com.hayde117.temi.database.fragments.list.ListAdapter by lazy { com.hayde117.temi.database.fragments.list.ListAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

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

        setHasOptionsMenu(true)

        return binding.root

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.db_menu, menu)

//        val search = menu?.findItem(R.id.search)
//        val searchView = search?.actionView as? SearchView
//
//        searchView?.isSubmitButtonEnabled
//        searchView?.setOnQueryTextListener(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.delete) {
            deleteAllUser()
        }
        return super.onOptionsItemSelected(item)

    }

    private fun deleteAllUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") {_, _ ->
            mUserViewModel.deleteALlUsers()
            Toast.makeText(requireContext(), "Successfully Deleted All From Database", Toast.LENGTH_SHORT).show()
//            findNavController().navigate(R.id.action_itemsFragment_to_viewItemsFragment)
        }

        builder.setNegativeButton("NO"){_, _ -> }
        builder.setTitle("Delete All Saved Results?")
        builder.create().show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {

        if (query != null) {
//            searchDatabase(query)
        }
        return true
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        TODO("Not yet implemented")
    }

//    private fun searchDatabase(query: String){
//        val searchQuery = "%$query"
//
//        // RecyclerView
//        val adapter = ListAdapter()
//
//        mUserViewModel.searchDatabase(searchQuery).observe(this, { list ->
//            list.let {
//               adapter.setDataSearch(it)
//            }
//
//        })
//    }
}