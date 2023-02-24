package com.example.animeapi.data.pagingsources

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bumptech.glide.load.HttpException
import com.example.animeapi.data.models.DataItem
import com.example.animeapi.data.remote.apiservices.MangaApiService
import java.io.IOException

class MangaPagingSource(private val service: MangaApiService) :
    PagingSource<Int, DataItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataItem> {
        try {
            val page = params.key ?: DEFAULT_PAGE_NUMBER

            val response = service.fetchManga(params.loadSize, page)
            val nextPageNumber =
                Uri.parse(response.links.next).getQueryParameter("page[offset]")!!.toInt()

            return LoadResult.Page(
                data = response.data,
                prevKey = null,
                nextKey = nextPageNumber

            )
        } catch (e: IOException) {
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, DataItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}