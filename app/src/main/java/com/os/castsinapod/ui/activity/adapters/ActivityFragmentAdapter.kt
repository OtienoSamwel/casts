package com.os.castsinapod.ui.activity.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.os.castsinapod.ui.activity.featture_subscriptions.SubscriptionFragment
import com.os.castsinapod.ui.activity.feature_downloads.DownloadsFragment
import com.os.castsinapod.ui.activity.feature_history.HistoryFragment
import com.os.castsinapod.ui.activity.feature_queue.QueueFragment

class ActivityFragmentAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    companion object{
         val myFragmentLabels = listOf("Your Queue", "Downloads", "History", "Subscriptions")
    }

    private val myFragmentList =
        listOf(
            QueueFragment(),
            DownloadsFragment(),
            HistoryFragment(),
            SubscriptionFragment()
        )

    override fun getItemCount(): Int {
        return myFragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return myFragmentList[position]
    }
}