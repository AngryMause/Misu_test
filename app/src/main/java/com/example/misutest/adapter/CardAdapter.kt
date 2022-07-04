package com.example.misutest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.misutest.App
import com.example.misutest.databinding.ItemDoctorInformationBinding
import com.example.misutest.model.DoctorDescription
import com.example.misutest.util.ConvertStringToBitmap

class CardAdapter() :
    RecyclerView.Adapter<CardAdapter.MyHolder>() {
    private val list = mutableListOf<DoctorDescription>()

    class MyHolder(val binding: ItemDoctorInformationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(docDisc: DoctorDescription) {
            val someText = docDisc.doctorName + docDisc.doctorSecondName
            binding.tvDoctorName.text = someText
            binding.tvDoctorSpacialty.text = docDisc.doctorSpecialty
            binding.tvLocation.text = docDisc.cityOfWork
            binding.tvDoctorDescription.text = docDisc.workDescription
            binding.rvWorkWith.apply {
                val docWith= DoctorWorkWithAdapter()
                docWith.addItem(docDisc.list)
                adapter = docWith
                layoutManager =
                    LinearLayoutManager(App.getContext(), RecyclerView.HORIZONTAL, false)
            }
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
        Glide.with(App.getContext()).load(docModel.avatar)
            .placeholder(ConvertStringToBitmap.avatarImage(
                200,
                docModel.doctorName,
                docModel.doctorSecondName))
            .into(holder.binding.doctorImage)
//        holder.binding.rvWorkWith.apply {
//            doctorWorkWithAdapter.addItem(docModel.list)
//            adapter = doctorWorkWithAdapter
//            layoutManager =
//                LinearLayoutManager(App.getContext(), RecyclerView.HORIZONTAL, false)
//        }
//        createAdapter(holder)
    }

    override fun getItemCount() = list.size

    fun addItems(newItems: List<DoctorDescription>) {
        list.addAll(newItems)
    }

//    private fun createAdapter(myHolder: MyHolder) {
//        myHolder.binding.rvWorkWith.apply {
//            adapter = doctorWorkWithAdapter
//            layoutManager = LinearLayoutManager(App.getContext(), RecyclerView.HORIZONTAL, false)
//        }
//    }

}