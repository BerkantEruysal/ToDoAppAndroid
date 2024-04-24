package com.example.hw2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw2.databinding.ToDoItemBinding

class ToDoAdapter(private val list: MutableList<Item>): RecyclerView.Adapter<ToDoAdapter.MyListViewHolder>() {

    inner class MyListViewHolder(private val binding: ToDoItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(getList: Item){
            binding.textView.text = getList.title
            binding.textView3.text = getList.description
            binding.imageButton2.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    // Tıklanan öğeyi listeden kaldır
                    list.removeAt(position)
                    notifyItemRemoved(position)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ToDoAdapter.MyListViewHolder {
        val binding = ToDoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ToDoAdapter.MyListViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

}