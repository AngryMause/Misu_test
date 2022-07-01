package com.example.misutest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

class BaseAdapter<T : Any>(
    private val list: List<T>,
    @LayoutRes val layoutId: Int,
    private val genericsRecyclerBinding: GenericsRecyclerBinding<T>
) :
    RecyclerView.Adapter<BaseAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        fun <T:Any>bind(item:T,)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
            return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = list.size

}