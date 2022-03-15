package com.os.casts.ui.home.adapters

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.os.casts.databinding.SearchItemBinding
import com.os.casts.ui.home.HomeFragmentDirections
import com.otienosamwel.data.models.PodcastsResponse

class SearchAdapter(private val data: PodcastsResponse) :
    RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {
    companion object {
        var place = 0
    }

    class SearchViewHolder(val binding: SearchItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = SearchItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        place = position
        val data = data.results[position]
        with(holder.binding) {

            playBtn.setOnClickListener {
                val action =
                    HomeFragmentDirections.actionHomeFragmentToMediaDrawerFragment(data.audio!!)
                root.findNavController().navigate(action)
            }
            root.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(data.id!!)
                root.findNavController().navigate(action)
            }
            podcastTitle.text = data.podcast.title_original
            description.text = data.description_original
            episodeTitle.text = data.title_original
            Glide.with(root)
                .load(data.podcast.thumbnail)
                .placeholder(ColorDrawable(Color.GRAY))
                .error(ColorDrawable(Color.RED))
                .centerCrop()
                .transform(RoundedCorners(10))
                .into(thumbnail)
        }
    }

    override fun getItemCount(): Int {
        return data.results.size
    }
}