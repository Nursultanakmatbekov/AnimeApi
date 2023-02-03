package com.example.animeapi.ui.fragments.getanimefragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapi.R
import com.example.animeapi.databinding.FragmentGetAnimeBinding
import com.example.animeapi.ui.adapters.AnimeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GetAnimeFragment : Fragment(R.layout.fragment_get_anime) {

    private val binding by viewBinding(FragmentGetAnimeBinding::bind)
    private val viewModel: GetAnimeViewModel by viewModels()
    private val animeAdapter = AnimeAdapter(this::setItemClickListener)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setUpObserves()
    }

    private fun initialize() {
        binding.recView.adapter = animeAdapter
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setUpObserves() {
        viewModel.fetchAnime().observe(viewLifecycleOwner) {
            animeAdapter.submitList(it.data)
            animeAdapter.notifyDataSetChanged()
        }
    }

    fun setItemClickListener(id: String) {
        findNavController().navigate(
            GetAnimeFragmentDirections.actionGetAnimeFragmentToDetailFragment(
                id.toInt()
            )
        )
    }
}
