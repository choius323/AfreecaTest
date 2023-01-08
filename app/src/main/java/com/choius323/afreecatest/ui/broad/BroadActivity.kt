package com.choius323.afreecatest.ui.broad

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.choius323.afreecatest.databinding.ActivityBroadBinding
import com.choius323.afreecatest.ui.broad.adapter.BroadTapPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BroadActivity : AppCompatActivity() {
    private val viewModel: BroadViewModel by viewModels()

    private lateinit var binding: ActivityBroadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBroadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                Log.d("BroadListActivity", "onPageSelected: $position")
                super.onPageSelected(position)
            }
        })
        initObserve()
    }

    private fun initObserve() {
        viewModel.categoryList.observe(this) { categories ->
            val fragments = categories.map { BroadListFragment.newInstance(it) }

            val pagerAdapter = BroadTapPagerAdapter(
                this, fragments
            )
            binding.viewPager.adapter = pagerAdapter
            TabLayoutMediator(
                binding.tablayoutBroadlist,
                binding.viewPager
            ) { tab: TabLayout.Tab, position: Int ->
                tab.text = categories[position].name
            }.attach()
        }
    }
}