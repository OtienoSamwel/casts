package com.os.castsinapod.ui.explore.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.os.castsinapod.ui.explore.features.ExploreFeaturesFragment

class ExploreFragmentAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    companion object {
        val myFragmentLabels = listOf(
            "For You",
            "News",
            "Culture",
            "Education",
            "Business",
            "Comedy",
            "Arts",
            "Technology",
            "Health & Fitness",
            "Science",
            "History",
            "Self-Improvement",
            "TV & Film",
            "Music",
            "Sport"
        )
    }

    override fun getItemCount(): Int {
        return myFragmentLabels.size
    }

    override fun createFragment(position: Int): Fragment {
        return ExploreFeaturesFragment()
    }
}