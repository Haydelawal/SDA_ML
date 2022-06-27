package com.hayde117.temi.database.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.hayde117.temi.R
import com.hayde117.temi.database.data.User
import com.hayde117.temi.databinding.ItemTasksBinding
import kotlinx.coroutines.flow.Flow

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder> () {


    private var userlist = emptyList<User>()


    class MyViewHolder(val binding: ItemTasksBinding): RecyclerView.ViewHolder(binding.root) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(ItemTasksBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }



    override fun getItemCount(): Int {
        return userlist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = userlist[position]

        holder.binding.apply {
            textViewProgress.text = currentItem.first_percent.toString()
            progressBar.progress = currentItem.first_percent
            textValue.text = currentItem.message
        }

        holder.binding.itemTasks.setOnClickListener {
            val action = ItemsFragmentDirections.actionItemsFragmentToViewItemsFragment(currentItem)

            holder.binding.itemTasks.findNavController().navigate(action)
        }




    }
    fun setData(user: List<User>) {
        this.userlist = user
        notifyDataSetChanged()
    }

//    fun setDataSearch(user: List<User>)
//    {
//        userlist = user
//        notifyDataSetChanged()
//    }



}