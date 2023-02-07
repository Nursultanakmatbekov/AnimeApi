package com.example.animeapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.animeapi.data.models.DataItem
import com.example.animeapi.databinding.ItemMangaBinding

class MangaAdapter (
    private val setItemClickListener: (id: String) -> Unit
) :
    ListAdapter<DataItem, MangaAdapter.MangaViewHolder>(diffUtil) {

    inner class MangaViewHolder(private val binding: ItemMangaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(bindingAdapterPosition).apply { setItemClickListener(id) }
            }
        }

        fun onBind(item: DataItem) {
            Glide.with(binding.imManga.context)
                .load(item.attributes.posterImage.original)
                .into(binding.imManga)
            binding.tvNameManga.text = item.attributes.titles.enJp
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaViewHolder {
        return MangaViewHolder(
            ItemMangaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MangaViewHolder, position: Int) {
        getItem(position).let {
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