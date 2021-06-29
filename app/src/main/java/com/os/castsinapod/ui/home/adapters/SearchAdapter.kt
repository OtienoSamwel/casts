package com.os.castsinapod.ui.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.os.castsinapod.R
import com.os.castsinapod.domain.models.PodcastResponse

class SearchAdapter(private val data: PodcastResponse, private val context: Context) :
    RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    class SearchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val thumbnail: ImageView = view.findViewById(R.id.thumbnail)
        val title: TextView = view.findViewById(R.id.title)
        val description: TextView = view.findViewById(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.search_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val data = data.results[position]
        holder.description.text = data.description_original
        holder.title.text = data.title_original
        Glide.with(context).load(data.thumbnail).into(holder.thumbnail)
    }

    override fun getItemCount(): Int {
        return data.results.size
    }
}