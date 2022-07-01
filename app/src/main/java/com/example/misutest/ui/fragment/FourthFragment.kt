package com.example.misutest.ui.fragment

import com.example.misutest.databinding.FragmentFourBinding

class FourthFragment : BaseFragment<FragmentFourBinding>(FragmentFourBinding::inflate) {
    companion object {
        fun getNewInstance(): FourthFragment {
            val fourthFragment = FourthFragment()
            return fourthFragment
        }

    }
}