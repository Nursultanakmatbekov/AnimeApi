package com.example.animeapi.ui.fragments.manga

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapi.base.BaseFragment
import com.example.animeapi.ui.adapters.MangaAdapter
import com.example.animeapi.ui.fragments.home.HomeFragmentDirections
import com.excample.animeapp.R
import com.excample.animeapp.databinding.FragmentMangaBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MangaFragment : BaseFragment<FragmentMangaBinding, MangaViewModel>(R.layout.fragment_manga) {

    override val binding by viewBinding(FragmentMangaBinding::bind)
    override val viewModel: MangaViewModel by viewModels()
    private val mangaAdapter = MangaAdapter(this::setItemClickListener)

    override fun setupSubscribes() {
        viewModel.fetchManga().observe(viewLifecycleOwner){
            lifecycleScope.launch {
                mangaAdapter.submitData(it)
            }
        }
    }

    override fun initialize() {
        binding.recView.adapter = mangaAdapter
    }

    private fun setItemClickListener(id: String){
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToMangaDetailFragment(id.toInt())
        )
    }
}
