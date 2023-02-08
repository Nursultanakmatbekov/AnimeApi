package com.example.animeapi.ui.fragments.manga

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapi.base.BaseFragment
import com.example.animeapi.extensions.showText
import com.example.animeapi.ui.adapters.MangaAdapter
import com.example.animeapi.ui.fragments.home.HomeFragmentDirections
import com.example.animeapi.utils.Resources
import com.example.animeapp.R
import com.example.animeapp.databinding.FragmentMangaBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaFragment : BaseFragment<FragmentMangaBinding, MangaViewModel>(R.layout.fragment_manga) {

    override val binding by viewBinding(FragmentMangaBinding::bind)
    override val viewModel: MangaViewModel by viewModels()
    private val mangaAdapter = MangaAdapter(this::onClickListeners)

    override fun initialize() {
        setupRecycler()
    }

    override fun setupSubscribes() {
        subscribeToManga()
    }

    private fun setupRecycler() = with(binding) {
        recView.adapter = mangaAdapter
    }

    private fun subscribeToManga() {
        viewModel.fetchManga().observe(viewLifecycleOwner) {
            when (it) {
                is Resources.Error -> {
                    showText("Error")
                }
                is Resources.Loading -> {
                    showText("Loading")
                }
                is Resources.Success -> {
                    it.data?.let { response ->
                        mangaAdapter.submitList(response.data)
                    }
                }
            }
        }
    }

    private fun onClickListeners(id: String) {
        findNavController().navigate(
            HomeFragmentDirections.actionPagerFragment2ToMangaDetailFragment(
                id.toInt()
            )
        )
    }
}