package com.arb.mvvm.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arb.mvvm.dataClass.MyDataClass
import com.arb.mvvm.databinding.CustomBinding

class MyAdapter(private var data: List<MyDataClass>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: CustomBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: MyDataClass) {
            binding.data = user
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val customItem = CustomBinding.inflate(inflater)
        return MyViewHolder(customItem)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) = holder.bind(data[position])

    override fun getItemCount(): Int = data.size

    fun reloadData(data: List<MyDataClass>) {
        this.data = data
        notifyDataSetChanged()
    }

}