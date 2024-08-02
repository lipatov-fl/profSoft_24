package com.example.profsoft24.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.profsoft24.R
import com.example.profsoft24.databinding.ActivityMainBinding
import com.example.profsoft24.models.TextWithBackgroundItem
import com.example.profsoft24.models.TextWithoutBackgroundItem
import com.example.profsoft24.recyclerView.MainAdapter
import com.example.profsoft24.viewPager.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = MainAdapter()
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRcView()
        initViewPager()
        initTabLayout()
        binding.buttonAdd.setOnClickListener {
            val newWithBgItem = TextWithBackgroundItem("Item ${adapter.itemCount + 1}")
            adapter.addItem(newWithBgItem)
            binding.recyclerView.scrollToPosition(adapter.itemCount - 1)
        }

        adapter.setOnItemClickListener { position ->
            adapter.removeItem(position)
        }
    }

    private fun initRcView() {
        binding.apply {
            recyclerView.adapter = adapter
            adapter.setItems(
                listOf(
                    *listOf(
                        TextWithoutBackgroundItem("item 1"),
                        TextWithoutBackgroundItem("item 2"),
                        TextWithoutBackgroundItem("item 3")
                    ).toTypedArray(),
                    *listOf(
                        TextWithBackgroundItem("item 4"),
                        TextWithBackgroundItem("item 5"),
                        TextWithBackgroundItem("item 6"),
                    ).toTypedArray(),
                )
            )
        }
    }

    private fun initViewPager() {
        viewPagerAdapter = ViewPagerAdapter()
        binding.viewPager.adapter = viewPagerAdapter
        val viewPagerItems = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
        viewPagerAdapter.setItems(viewPagerItems)
    }

    private fun initTabLayout() {
        tabLayout = binding.tabLayout

        val mediator = TabLayoutMediator(tabLayout, binding.viewPager) { tab, position ->
            val tabView = LayoutInflater.from(tabLayout.context)
                .inflate(R.layout.custom_tab, null)
            val dotView = tabView.findViewById<View>(R.id.tab_dot)

            dotView.setBackgroundResource(R.drawable.dot_not_active_shape)
            tab.customView = tabView
        }
        mediator.attach()

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                for (i in 0 until tabLayout.tabCount) {
                    val tab = tabLayout.getTabAt(i)
                    if (tab != null && tab.customView != null) {
                        val dotView = tab.customView?.findViewById<View>(R.id.tab_dot)
                        if (i == position) {
                            dotView?.setBackgroundResource(R.drawable.dot_active_shape)
                        } else {
                            dotView?.setBackgroundResource(R.drawable.dot_not_active_shape)
                        }
                    }
                }
            }
        })
        if (tabLayout.tabCount > 0) {
            val firstTab = tabLayout.getTabAt(0)
            firstTab?.let {
                it.select()
                val dotView = it.customView?.findViewById<View>(R.id.tab_dot)
                dotView?.setBackgroundResource(R.drawable.dot_active_shape)
            }
        }
    }
}