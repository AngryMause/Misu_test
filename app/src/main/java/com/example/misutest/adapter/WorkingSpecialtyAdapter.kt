package com.example.misutest.adapter

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.graphics.drawable.toDrawable
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Visibility
import com.example.misutest.R
import com.example.misutest.databinding.ItemRvSpecialtyDoctorBinding

class WorkingSpecialtyAdapter() : RecyclerView.Adapter<WorkingSpecialtyAdapter.MyHolder>() {
    private val list = mutableListOf(" Сімейний лікар ", " Педіатр ", " Ендокринолог ", " Хірург ")

    class MyHolder(val binding: ItemRvSpecialtyDoctorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onClick() {
            binding.tvDoctorSpecialty.setOnClickListener {
                binding.tvDoctorSpecialty.isVisible = false
                binding.textIsActive.isVisible = true
            }
            binding.textIsActive.setOnClickListener {
                binding.tvDoctorSpecialty.isVisible = true
                binding.textIsActive.isVisible = false
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(

            ItemRvSpecialtyDoctorBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val str = list[position]
        holder.binding.tvDoctorSpecialty.text = str
        holder.binding.textIsActive.text = str
        holder.onClick()

    }

    override fun getItemCount() = list.size

}