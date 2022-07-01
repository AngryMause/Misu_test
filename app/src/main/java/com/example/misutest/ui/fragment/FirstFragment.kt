package com.example.misutest.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.misutest.R
import com.example.misutest.adapter.CardAdapter
import com.example.misutest.adapter.WorkingSpecialtyAdapter
import com.example.misutest.databinding.FragmentFirstBinding
import com.example.misutest.model.DoctorDescription

class FirstFragment : BaseFragment<FragmentFirstBinding>(FragmentFirstBinding::inflate) {

    private lateinit var cardAdapter: CardAdapter
    private val list: ArrayList<DoctorDescription> = ArrayList()

    companion object {
        fun getNewInstance(): FirstFragment {
            return FirstFragment()
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cardAdapter = CardAdapter(requireContext())
        setDataToModel()
        cardAdapter.addItems(list)
        initAdapter()
        initSpecialtyAdapter()
    }

    fun initAdapter() = binding?.rvDoctorDescription?.apply {
        adapter = cardAdapter
        layoutManager = LinearLayoutManager(requireContext())
    }

    private fun initSpecialtyAdapter() = binding?.rvSpecialtyDoctor?.apply {
        val specialtyAdapter = WorkingSpecialtyAdapter()
        adapter = specialtyAdapter
        layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        val itemAnimator = itemAnimator
        if (itemAnimator is DefaultItemAnimator) {
            itemAnimator.supportsChangeAnimations = false
        }
    }

    fun setDataToModel() {
        for (i in 0..5) {
            if (i % 2 == 0) {
                list.add(
                    DoctorDescription(
                        R.drawable.ic_doctor,
                        "Inna " + i,
                        "Gonrat" + i,
                        "Family doctor",
                        "м.Rivne",
                        "Я дура, що із мене взяти" + i
                    )
                )
            } else {
                list.add(
                    DoctorDescription(
                        null,
                        "Vera " + i,
                        "Rubic" + i,
                        "Family doctor",
                        "м.Тернопіль",
                        "Самі ви дебіли!!!" + i
                    )
                )
            }


//            for (e:DoctorDescription in list ){
//                if (e.avatar==null){
//
//                }
//            }

        }


    }


}
