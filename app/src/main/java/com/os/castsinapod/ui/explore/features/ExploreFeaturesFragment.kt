package com.os.castsinapod.ui.explore.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.os.castsinapod.R
import com.os.castsinapod.ui.explore.adapters.ExploreFragmentAdapter


class ExploreFeaturesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore_features, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text: TextView = view.findViewById(R.id.exp_feature_text)

        text.text = ExploreFragmentAdapter.myFragmentLabels[ExploreFragmentAdapter.positioning]
    }
}