package com.os.castsinapod.ui.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.os.castsinapod.R
import com.os.castsinapod.ui.explore.adapters.ExploreFragmentAdapter


class ExploreFragment : Fragment() {

    private var _binding: FragmentExploreBinding? = null
    private val binding: FragmentExploreBinding get() = _binding!!
    private lateinit var viewpager: ViewPager2
    private lateinit var exploreFragmentAdapter: ExploreFragmentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        exploreFragmentAdapter = ExploreFragmentAdapter(this)
        viewpager = view.findViewById(R.id.explore_viewpager)
        viewpager.adapter = exploreFragmentAdapter

        val tabLayout: TabLayout = view.findViewById(R.id.explore_tab_layout)

        TabLayoutMediator(tabLayout, viewpager) { tab, position ->
            tab.text = ExploreFragmentAdapter.myFragmentLabels[position]
        }.attach()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}