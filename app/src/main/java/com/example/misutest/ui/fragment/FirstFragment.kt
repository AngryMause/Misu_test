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
import com.example.misutest.model.DoctorWorkWith

class FirstFragment : BaseFragment<FragmentFirstBinding>(FragmentFirstBinding::inflate) {
    private lateinit var cardAdapter: CardAdapter
    private lateinit var specialtyAdapter: WorkingSpecialtyAdapter
    private var doctorDescriptionList: ArrayList<DoctorDescription> = ArrayList()

    companion object {
        fun getNewInstance(): FirstFragment {
            return FirstFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDataToDoctorDescription()
        initCardAdapter()
        cardAdapter.addItems(doctorDescriptionList)
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


    private fun setDataToDoctorDescription() {
        for (i in 0..5) {
            if (i % 2 == 0) {
                doctorDescriptionList.add(
                    DoctorDescription(
                        R.drawable.ic_doctor,
                        "Ivan",
                        "Gonrat",
                        "Family doctor",
                        "м.Rivne",
                        listOf(DoctorWorkWith("Діти 0-3р."),
                            DoctorWorkWith("Дорослі"),
                            DoctorWorkWith("Covid-19")),
                        "Проводить первинний лікарський патронаж новонародженого "
                    )
                )
            } else {
                doctorDescriptionList.add(
                    DoctorDescription(
                        null,
                        "Vera ",
                        "Rubic",
                        "Family doctor",
                        "м.Тернопіль",
                        listOf(DoctorWorkWith("Дорослі"), DoctorWorkWith("Covid-19")),
                        "Веде прийом для дітей"
                    )
                )
            }
        }


    }


}
