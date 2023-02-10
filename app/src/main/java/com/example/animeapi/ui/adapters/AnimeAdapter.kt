package com.example.animeapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.animeapi.data.models.DataItem
import com.example.animeapp.databinding.ItemAnimeBinding

class AnimeAdapter(val setItemClickListener: (id: String) -> Unit) :
    PagingDataAdapter<DataItem, AnimeAdapter.AnimeViewHolder>(diffUtil) {

    inner class AnimeViewHolder(private val binding: ItemAnimeBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun onBind(item: DataItem) = with(binding) {
            Glide.with(binding.imItem.context)
                .load(item.attributes.posterImage.original)
                .into(binding.imItem)
            binding.tvNameItem.text = item.attributes.titles.enJp
        }

        init {
            itemView.setOnClickListener {
                getItem(bindingAdapterPosition)?.apply { setItemClickListener(id) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        return AnimeViewHolder(
            ItemAnimeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }


    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<DataItem>() {
            override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem.attributes.titles == newItem.attributes.titles
            }

            override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}