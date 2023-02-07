package com.example.animeapi.ui.fragments.pager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapi.R
import com.example.animeapi.base.BaseFragment
import com.example.animeapi.databinding.FragmentPagerBinding
import com.example.animeapi.ui.adapters.PagersAdapter
import com.example.animeapi.ui.fragments.animefragment.AnimeFragment
import com.example.animeapi.ui.fragments.manga.MangaFragment
import dagger.hilt.android.AndroidEntryPoint

class PagerFragment : Fragment(R.layout.fragment_pager) {

    private val binding by viewBinding(FragmentPagerBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        tabLayout()
    }

    private fun tabLayout() {
        val pagerAdapter = PagersAdapter(childFragmentManager)
        pagerAdapter.addFragment(AnimeFragment(), "Anime")
        pagerAdapter.addFragment(MangaFragment(), "Manga")

        binding.viewPager.adapter = pagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}