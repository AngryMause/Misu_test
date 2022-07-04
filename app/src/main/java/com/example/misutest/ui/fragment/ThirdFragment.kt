package com.example.misutest.ui.fragment

import com.example.misutest.databinding.FragmentThirdBinding

class ThirdFragment : BaseFragment<FragmentThirdBinding>(FragmentThirdBinding::inflate) {
    companion object {
        fun getNewInstance(): ThirdFragment {
            return ThirdFragment()
        }
    }

}