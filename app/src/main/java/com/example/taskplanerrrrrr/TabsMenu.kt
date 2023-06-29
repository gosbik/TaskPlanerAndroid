package com.example.taskplanerrrrrr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.taskplanerrrrrr.databinding.ActivityTabsMenuBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class TabsMenu : AppCompatActivity() {
    private val fragList = listOf(CurrentFragment.newInstance(), ComletedFragment.newInstance())
    private lateinit var binding : ActivityTabsMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTabsMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tb.addOnTabSelectedListener(object: OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                supportFragmentManager.beginTransaction().replace(R.id.placeHolder, fragList[tab?.position!!]).commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

    }
}