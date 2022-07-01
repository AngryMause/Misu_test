package com.example.misutest.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.misutest.R
import com.example.misutest.adapter.CardAdapter
import com.example.misutest.adapter.WorkingSpecialtyAdapter
import com.example.misutest.databinding.FragmentFirstBinding
import com.example.misutest.model.DoctorDescription

class FirstFragment : BaseFragment<FragmentFirstBinding>(FragmentFirstBinding::inflate) {
    private lateinit var cardAdapter: CardAdapter
    private lateinit var specialtyAdapter: WorkingSpecialtyAdapter
    private var list: ArrayList<DoctorDescription> = ArrayList()


    companion object {
        fun getNewInstance(): FirstFragment {
            return FirstFragment()
        }
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDataToModel()
        initCardAdapter()
        cardAdapter.addItems(list)
        initSpecialtyAdapter()
    }

    private fun initSpecialtyAdapter() = binding?.rvSpecialtyDoctor?.apply {
        specialtyAdapter = WorkingSpecialtyAdapter()
        adapter = specialtyAdapter
        layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
    }

    fun initCardAdapter() = binding?.rvDoctorDescription?.apply {
        cardAdapter = CardAdapter()
        adapter = cardAdapter
        layoutManager = LinearLayoutManager(requireContext())
    }


    private fun setDataToModel() {
        for (i in 0..5) {
            if (i % 2 == 0) {
                list.add(
                    DoctorDescription(
                        R.drawable.ic_doctor,
                        "Inna " + i,
                        "Gonrat" + i,
                        "Family doctor",
                        "м.Rivne",
                        "Працюю із дітками"
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
                        "Приваблива" + i
                    )
                )
            }
        }
    }


}
