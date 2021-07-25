package com.os.castsinapod.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.os.castsinapod.R
import com.os.castsinapod.ui.home.adapters.SearchAdapter
import com.os.castsinapod.ui.home.viewmodels.HomeFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!
    private val viewModel: HomeFragmentViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.home_fragment_recycler_view)
        viewModel.getResults("harry")
        viewModel.data.observe(viewLifecycleOwner) {
            recyclerView.adapter = SearchAdapter(it, requireContext()) { onClick() }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
