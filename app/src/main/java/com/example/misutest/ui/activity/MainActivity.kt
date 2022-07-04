package com.example.misutest.ui.activity

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.misutest.databinding.ActivityMainBinding
import com.example.misutest.ui.fragment.FirstFragment
import com.example.misutest.ui.fragment.FourthFragment
import com.example.misutest.ui.fragment.SecondFragment
import com.example.misutest.ui.fragment.ThirdFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        swapFragment()


    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(binding.mainContainer.id, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun swapFragment() {
        binding.tvOne.setTextColor(Color.BLUE)
        replaceFragment(FirstFragment.getNewInstance())
        binding.tvOne.setOnClickListener {
            binding.tvThird.setTextColor(Color.BLACK)
            binding.tvOne.setTextColor(Color.BLUE)
            binding.tvFour.setTextColor(Color.BLACK)
            replaceFragment(FirstFragment.getNewInstance())
        }
        binding.tvSecond.setOnClickListener {
            binding.tvOne.setTextColor(Color.BLACK)
            binding.tvFour.setTextColor(Color.BLACK)
            binding.tvThird.setTextColor(Color.BLACK)
            SecondFragment().show(supportFragmentManager, "tag")
        }
        binding.tvThird.setOnClickListener {
            binding.tvThird.setTextColor(Color.BLUE)
            binding.tvOne.setTextColor(Color.BLACK)
            binding.tvFour.setTextColor(Color.BLACK)
            replaceFragment(ThirdFragment.getNewInstance())

        }
        binding.tvFour.setOnClickListener {
            binding.tvThird.setTextColor(Color.BLACK)
            binding.tvOne.setTextColor(Color.BLACK)
            binding.tvFour.setTextColor(Color.BLUE)
            replaceFragment(FourthFragment.getNewInstance())
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null!!
    }
}