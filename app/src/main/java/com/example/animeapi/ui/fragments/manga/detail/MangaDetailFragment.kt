package com.example.animeapi.ui.fragments.manga.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.animeapi.R
import com.example.animeapi.base.BaseFragment
import com.example.animeapi.databinding.FragmentMangaDetailBinding
import com.example.animeapi.extensions.showText
import com.example.animeapi.utils.Resources
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaDetailFragment : BaseFragment<FragmentMangaDetailBinding, MangaDetailViewModel>(
    R.layout.fragment_manga_detail
) {

    override val viewModel: MangaDetailViewModel by viewModels()
    override val binding by viewBinding(FragmentMangaDetailBinding::bind)
    private val args by navArgs<MangaDetailFragmentArgs>()

    override fun setupSubscribes() {
        subscribeToAnimeById()
    }

    private fun subscribeToAnimeById() = with(binding) {
        viewModel.mangaDetail(args.id).observe(viewLifecycleOwner) {
            when(it) {
                is Resources.Error -> {
                    showText("Error")
                }
                is Resources.Loading -> {
                    showText("Loading")
                }
                is Resources.Success -> {
                    Glide.with(ivFullscreenManga.context)
                        .load(it.data?.data?.attributes?.posterImage?.original)
                        .into(ivFullscreenManga)
                    tvNameDetailManga.text = it.data?.data?.attributes?.titles?.enJp
                }
            }
        }
    }
}