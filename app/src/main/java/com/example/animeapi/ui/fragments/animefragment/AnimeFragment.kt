package com.example.animeapi.ui.fragments.animefragment

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapi.R
import com.example.animeapi.base.BaseFragment
import com.example.animeapi.databinding.FragmentAnimeBinding
import com.example.animeapi.extensions.showText
import com.example.animeapi.ui.adapters.AnimeAdapter
import com.example.animeapi.ui.adapters.MangaAdapter
import com.example.animeapi.ui.fragments.pager.PagerFragmentDirections
import com.example.animeapi.utils.Resources
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeFragment : BaseFragment<FragmentAnimeBinding, AnimeViewModel>(R.layout.fragment_anime) {

    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel: AnimeViewModel by viewModels()
    private val animeAdapter = AnimeAdapter(this::setItemClickListener)

    override fun initialize() {
        setupRecycler()
    }

    override fun setupSubscribes() {
        subscribeToAnimeById()
    }

    private fun setupRecycler() = with(binding) {
        recView.adapter = animeAdapter
    }

    private fun subscribeToAnimeById() {
        viewModel.fetchAnime().observe(viewLifecycleOwner) {
            when (it) {
                is Resources.Error -> {
                    showText("Error")
                }
                is Resources.Loading -> {
                    showText("Loading")
                }
                is Resources.Success -> {
                    animeAdapter.submitList(it.data?.data)
                }
            }
        }
    }

    fun setItemClickListener(id: String) {
        findNavController().navigate(
            PagerFragmentDirections.actionPagerFragment2ToDetailFragment2(
                id.toInt()
            )
        )
    }
}
