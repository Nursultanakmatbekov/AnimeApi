package com.example.animeapi.ui.fragments.animefragment.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.animeapi.R
import com.example.animeapi.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val viewModel: DetailViewModel by viewModels()
    private val binding by viewBinding(FragmentDetailBinding::bind)
    private val args by navArgs<DetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initial()
    }

    private fun initial() = with(binding) {
        viewModel.animeDetail(args.id).observe(viewLifecycleOwner) {
            Glide.with(imView.context)
                .load(it.data.attributes.posterImage.original)
                .into(imView)
            tvTitle.text = it.data.attributes.titles.enJp
        }
    }
}