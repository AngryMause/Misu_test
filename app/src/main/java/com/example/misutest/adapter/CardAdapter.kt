package com.example.misutest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.misutest.util.AvatarGenerator
import com.example.misutest.databinding.ItemDoctorInformationBinding
import com.example.misutest.model.DoctorDescription

class CardAdapter(private val context: Context) :
    RecyclerView.Adapter<CardAdapter.MyHolder>() {
    private val list = mutableListOf<DoctorDescription>()


    class MyHolder(val binding: ItemDoctorInformationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(docDisc: DoctorDescription) {
            val someText= docDisc.doctorName + docDisc.doctorSecondName
            binding.tvDoctorName.text = someText
            binding.tvDoctorSpacialty.text = docDisc.doctorSpecialty
            binding.tvLocation.text = docDisc.cityOfWork
            binding.tvDoctorDescription.text = docDisc.workDescription
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            ItemDoctorInformationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val docModel = list[position]
        holder.bind(docModel)
            Glide.with(context).load(docModel.avatar)
                .placeholder(AvatarGenerator.avatarImage(
                    200,
                    docModel.doctorName,
                    docModel.doctorSecondName))
                .into(holder.binding.doctorImage)
    }

    override fun getItemCount() = list.size

    fun addItems(newItems: List<DoctorDescription>) {
        list.addAll(newItems)
    }


}