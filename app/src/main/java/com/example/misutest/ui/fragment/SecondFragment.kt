package com.example.misutest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.FrameLayout
import com.example.misutest.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SecondFragment : BottomSheetDialogFragment() {
    override fun getTheme() = R.style.AppBottomSheetDialogTheme
    override fun onStart() {
        super.onStart()
        initBottomSheet()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? = inflater.inflate(R.layout.fragment_second, container, false)


    private fun initBottomSheet() {
        dialog?.let {
            val bottomSheet =
                it.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
            bottomSheet.let {
                val bihavor = BottomSheetBehavior.from(bottomSheet)
                setUpFullHeigth(it)
                bihavor.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
    }

    private fun setUpFullHeigth(bottomSheet: View) {
        val layoutParams = bottomSheet.layoutParams
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
        bottomSheet.layoutParams = layoutParams
    }
}