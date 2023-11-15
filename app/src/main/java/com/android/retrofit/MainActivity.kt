package com.android.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.android.retrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)

        binding.apply {
            btn1.setOnClickListener {
                setFragment(firstFragment())
            }
            btn2.setOnClickListener {
                setFragment(secondFragment())
            }
        }
    }
    private fun setFragment(frag: Fragment) {
            supportFragmentManager.commit{
                replace(R.id.activity_main_layout, frag)
                setReorderingAllowed(true)
                addToBackStack("") // Backstack은뭐지?
            }
    }
}
