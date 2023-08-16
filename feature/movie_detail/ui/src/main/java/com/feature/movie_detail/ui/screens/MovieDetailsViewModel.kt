package com.feature.movie_detail.ui.screens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.UiEvent
import com.feature.movie_detail.domain.use_cases.GetMovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _movieDetails = mutableStateOf(MovieDetailsStateHolder())
    val movieDetails: State<MovieDetailsStateHolder> get() = _movieDetails

    private val API_KEY = "4072d9f84095d35157531c672880b3d5"

    init {
        savedStateHandle.getLiveData<String>("id").observeForever { id ->
            id?.let {
                getMovieDetails(id, API_KEY)
            }
        }
    }

    private fun getMovieDetails(id: String, apiKey: String) {
        getMovieDetailsUseCase(id, apiKey).onEach { event ->
            when (event) {
                is UiEvent.Loading -> {
                    _movieDetails.value = MovieDetailsStateHolder(isLoading = true)
                }

                is UiEvent.Error -> {
                    _movieDetails.value = MovieDetailsStateHolder(error = event.message)
                }

                is UiEvent.Success -> {
                    _movieDetails.value = MovieDetailsStateHolder(data = event.data)
                }
            }
        }.launchIn(viewModelScope)
    }

}