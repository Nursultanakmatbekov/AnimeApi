package com.example.animeapi.ui.fragments.anime.detail

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.animeapi.base.BaseFragment
import com.excample.animeapp.R
import com.excample.animeapp.databinding.FragmentAnimeDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailFragment : BaseFragment<FragmentAnimeDetailBinding, AnimeDetailViewModel>(
    R.layout.fragment_anime_detail
) {

    override val viewModel: AnimeDetailViewModel by viewModels()
    override val binding by viewBinding(FragmentAnimeDetailBinding::bind)
    private val args by navArgs<AnimeDetailFragmentArgs>()

    override fun setupSubscribes() {
        subscribeToAnimeById()
    }

    private fun subscribeToAnimeById() = with(binding) {
        viewModel.animeDetail(args.id).subscribe(
            onError = {
                Toast.makeText(requireContext(), "asd", Toast.LENGTH_SHORT).show()
            },
            onSuccess = {
                it.data.let {
                    Glide.with(imView.context)
                        .load(it.attributes.posterImage.original)
                        .into(imView)
                    tvTitle.text = it.attributes.titles.enJp
                }
            })
    }
}