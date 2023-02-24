package com.fauzan.submission


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fauzan.submission.databinding.ItemRowUserBinding

class ListUserAdapter(private val arrayUser: ArrayList<DataUser>, val context: Context): RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {

    class ListViewHolder(var binding : ItemRowUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItems(user : DataUser){
            binding.imgItemPhoto.setImageResource(user.avatar)
            binding.tvItemName.text = user.name
            binding.tvItemLocation.text = user.location
            binding.tvItemCompany.text = user.company
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListUserAdapter.ListViewHolder, position: Int) {
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