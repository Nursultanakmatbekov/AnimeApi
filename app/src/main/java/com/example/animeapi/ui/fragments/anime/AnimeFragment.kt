package com.example.animeapi.ui.fragments.anime

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapi.base.BaseFragment
import com.example.animeapi.ui.adapters.AnimeAdapter
import com.example.animeapi.ui.fragments.home.HomeFragmentDirections
import com.excample.animeapp.R
import com.excample.animeapp.databinding.FragmentAnimeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment : BaseFragment<FragmentAnimeBinding, AnimeViewModel>(R.layout.fragment_anime) {

    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel: AnimeViewModel by viewModels()
    private val animeAdapter = AnimeAdapter(this::setItemClickListener)

    override fun setupSubscribes() {
        viewModel.fetchAnime().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                animeAdapter.submitData(it)
            }
        }
    }

    override fun initialize() {
        binding.recView.adapter = animeAdapter
    }


    private fun setItemClickListener(id: String) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragment2ToAnimeDetailFragment2(id.toInt())
        )
    }
}