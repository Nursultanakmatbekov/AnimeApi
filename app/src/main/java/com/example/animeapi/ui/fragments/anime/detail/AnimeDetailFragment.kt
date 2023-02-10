package com.example.animeapi.ui.fragments.anime.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.animeapi.base.BaseFragment
import com.example.animeapi.extensions.showText
import com.example.animeapi.utils.Resources
import com.example.animeapp.R
import com.example.animeapp.databinding.FragmentAnimeDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailFragment: BaseFragment<FragmentAnimeDetailBinding, AnimeDetailViewModel>(
    R.layout.fragment_anime_detail
) {

    override val viewModel: AnimeDetailViewModel by viewModels()
    override val binding by viewBinding(FragmentAnimeDetailBinding::bind)
    private val args by navArgs<AnimeDetailFragmentArgs>()

    override fun setupSubscribes() {
        subscribeToAnimeById()
    }

    private fun subscribeToAnimeById() = with(binding) {
        viewModel.animeDetail(args.id).observe(viewLifecycleOwner) {
            when(it) {
                is Resources.Error -> {
                    showText("Error")
                }
                is Resources.Loading -> {
                    showText("Loading")
                }
                is Resources.Success -> {
                    Glide.with(imView.context)
                        .load(it.data?.data?.attributes?.posterImage?.original)
                        .into(imView)
                    tvTitle.text = it.data?.data?.attributes?.titles?.enJp
                }
            }
        }
    }
}