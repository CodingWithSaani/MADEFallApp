package com.parukh.madefallapp.Lecture061223

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.parukh.madefallapp.R

class RVAdapter(val context: Context,val userList:MutableList<RVModel>):RecyclerView.Adapter<RVAdapter.RVAdapterViewHolder> ()
{

    inner class RVAdapterViewHolder(val singleItem: View):RecyclerView.ViewHolder(singleItem)
    {
        var userNameTV:TextView = singleItem.findViewById(R.id.si_user_name_tv)
        var userEmailTV:TextView = singleItem.findViewById(R.id.si_user_email_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapterViewHolder {
        return RVAdapterViewHolder(
            LayoutInflater.from(context).inflate(R.layout.single_item,parent,false) //kotlin representation of xml object
        )
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: RVAdapterViewHolder, position: Int) {
        holder.userNameTV.text = userList[position].userName
        holder.userEmailTV.text = userList[position].userEmail

        holder.userNameTV.setOnClickListener {
            Toast.makeText(context,userList[position].userName,Toast.LENGTH_LONG).show()
        }
    }
}













