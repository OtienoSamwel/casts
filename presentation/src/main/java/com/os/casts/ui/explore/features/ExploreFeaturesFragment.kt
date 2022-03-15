package com.os.casts.ui.explore.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.os.casts.databinding.FragmentExploreFeaturesBinding
import com.os.casts.ui.explore.adapters.ExploreFragmentAdapter
import com.os.casts.ui.home.adapters.SearchAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExploreFeaturesFragment : Fragment() {
    private var _binding: FragmentExploreFeaturesBinding? = null
    private val binding: FragmentExploreFeaturesBinding get() = _binding!!
    private val viewModel: ExploreFeaturesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentExploreFeaturesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getResults(ExploreFragmentAdapter.myFragmentLabels[ExploreFragmentAdapter.positioning])
        viewModel.data.observe(viewLifecycleOwner) {
            binding.exploreFeaturesRecyclerview.adapter = SearchAdapter(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}