package com.example.animeapi.ui.fragments.manga.detail

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.animeapi.base.BaseFragment
import com.excample.animeapp.R
import com.excample.animeapp.databinding.FragmentMangaDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaDetailFragment : BaseFragment<FragmentMangaDetailBinding, MangaDetailViewModel>(
    R.layout.fragment_manga_detail
) {

    override val viewModel: MangaDetailViewModel by viewModels()
    override val binding by viewBinding(FragmentMangaDetailBinding::bind)
    private val args by navArgs<MangaDetailFragmentArgs>()

    override fun setupSubscribes() {
        subscribeToMangaId()
    }

    private fun subscribeToMangaId() = with(binding) {
        viewModel.mangaDetail(args.id).subscribe(
            onError = {
                Toast.makeText(requireContext(), "asd", Toast.LENGTH_SHORT).show()
            },
            onSuccess = {
                it.data.let {
                    Glide.with(ivFullscreenManga.context)
                        .load(it.attributes.posterImage.original)
                        .into(ivFullscreenManga)
                    tvNameDetailManga.text = it.attributes.titles.enJp
                }
            })
    }
}