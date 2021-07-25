package com.os.castsinapod.ui.details

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.os.castsinapod.R
import com.os.castsinapod.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding: FragmentDetailBinding get() = _binding!!
    private val viewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getPodcast(args.podcastId)

        viewModel.data.observe(viewLifecycleOwner) {
            with(binding) {
                podcastTitle.text = it.title
                podcastAuthor.text = it.publisher
                descriptionTxt.text = it.description
                numberOfEpisodesTxt.text =
                    getString(R.string.episodes, it.total_episodes, "Episodes")

                Glide.with(this@DetailFragment)
                    .load(it.image)
                    .placeholder(ColorDrawable(Color.GRAY))
                    .error(ColorDrawable(Color.RED))
                    .centerCrop()
                    .transform(RoundedCorners(10))
                    .into(podcastImage)
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}