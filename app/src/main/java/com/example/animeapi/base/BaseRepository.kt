package com.example.animeapi.base

import com.example.animeapi.utils.Resources
import kotlinx.coroutines.flow.flow

abstract class BaseRepository {

    protected open fun <T> doRequest(request: suspend () -> T) = flow {
        emit(Resources.Loading())
        try {
            emit(Resources.Success(request()))
        } catch (ioException: Exception) {
            emit(Resources.Error(ioException.localizedMessage ?: "Error"))
        }
    }
}