package com.os.castsinapod.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.SimpleExoPlayer
import com.os.castsinapod.databinding.FragmentHomeBinding
import com.os.castsinapod.ui.home.adapters.SearchAdapter
import com.os.castsinapod.ui.home.viewmodels.HomeFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!
    private val viewModel: HomeFragmentViewModel by viewModels()

    @Inject
    lateinit var player: SimpleExoPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = binding.homeFragmentRecyclerView

        binding.viewStub.visibility = View.VISIBLE
        viewModel.getResults("harry")
        viewModel.data.observe(viewLifecycleOwner) {
            binding.viewStub.visibility =View.INVISIBLE
            recyclerView.adapter = SearchAdapter(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
