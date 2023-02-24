package com.fauzan.submission

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fauzan.submission.databinding.ItemGridUserBinding

class GridUserAdapter(private val arrayUser: ArrayList<DataUser>, val context: Context): RecyclerView.Adapter<GridUserAdapter.GridViewHolder>() {

    class GridViewHolder(var binding : ItemGridUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItems(user : DataUser){
            binding.imgItemPhoto.setImageResource(user.avatar)
            binding.tvDetailUser.text = "@${user.username}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val binding = ItemGridUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GridViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GridUserAdapter.GridViewHolder, position: Int) {
        holder.bindItems(arrayUser[position])
        holder.itemView.setOnClickListener {
            val user = arrayUser.get(position)
            val moveWithObjectIntent = Intent(context, DetailPageActivity::class.java)
            moveWithObjectIntent.putExtra(DetailPageActivity.EXTRA_USER, user)
            context.startActivity(moveWithObjectIntent)
        }
    }

    override fun getItemCount(): Int = arrayUser.size
}