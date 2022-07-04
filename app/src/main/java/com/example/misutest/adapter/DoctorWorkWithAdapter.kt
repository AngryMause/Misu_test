package com.example.misutest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.misutest.databinding.ItemWorkWithBinding
import com.example.misutest.model.DoctorWorkWith

class DoctorWorkWithAdapter() :
    RecyclerView.Adapter<DoctorWorkWithAdapter.WorkWithHolder>() {
    private var list = mutableListOf<DoctorWorkWith>()
    class WorkWithHolder(val binding: ItemWorkWithBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkWithHolder {
        return WorkWithHolder(
            ItemWorkWithBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ))
    }
    override fun onBindViewHolder(holder: WorkWithHolder, position: Int) {
        holder.binding.tvAgeOfPatients.text = list[position].workWith
    }
    override fun getItemCount() = list.size
    fun addItem(newItem: List<DoctorWorkWith>) {
        list.addAll(newItem)
    }


}