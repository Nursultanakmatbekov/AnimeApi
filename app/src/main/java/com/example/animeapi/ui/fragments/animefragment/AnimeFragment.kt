package com.example.animeapi.ui.fragments.animefragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapi.R
import com.example.animeapi.databinding.FragmentAnimeBinding
import com.example.animeapi.ui.adapters.AnimeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeFragment : Fragment(R.layout.fragment_anime) {

    private val binding by viewBinding(FragmentAnimeBinding::bind)
    private val viewModel: AnimeViewModel by viewModels()
    private val animeAdapter = AnimeAdapter(this::setItemClickListener)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setUpObserves()
    }

    private fun initialize() {
        binding.recView.adapter = animeAdapter
    }

    private fun setUpObserves() {
        viewModel.fetchAnime().observe(viewLifecycleOwner) {
            animeAdapter.submitList(it.data)
        }
    }

    fun setItemClickListener(id: String) {
        findNavController().navigate(
            AnimeFragmentDirections.actionGetAnimeFragmentToDetailFragment(
                id.toInt()
            )
        )
    }
}
