package com.os.casts.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.os.casts.R
import com.os.casts.ui.activity.adapters.ActivityFragmentAdapter

class ActivityFragment : Fragment() {

    private lateinit var viewpager: ViewPager2
    private lateinit var fragmentAdapter: ActivityFragmentAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_activity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentAdapter = ActivityFragmentAdapter(this)
        viewpager = view.findViewById(R.id.activity_view_pager)
        viewpager.adapter = fragmentAdapter

        val tabLayout: TabLayout = view.findViewById(R.id.activity_tab_layout)

        TabLayoutMediator(tabLayout, viewpager) { tab, position ->
            tab.text = ActivityFragmentAdapter.myFragmentLabels[position]
        }.attach()
    }
}