package com.feature.movie.ui.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.UiEvent
import com.feature.movie.domain.use_cases.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieSearchViewModel @Inject constructor(
    private val movieListUseCase: GetMovieListUseCase,
) : ViewModel() {

    private val _movieList = mutableStateOf(MovieSearchStateHolder())
    val movieList: State<MovieSearchStateHolder> get() = _movieList

    private val _query: MutableStateFlow<String> = MutableStateFlow("")
    val query = _query.asStateFlow()

    val API_KEY = "4072d9f84095d35157531c672880b3d5"

    init {
        viewModelScope.launch {
            _query.debounce(1000).collectLatest {
                getMovieList(API_KEY, it)
            }
        }
    }

    private fun getMovieList(apiKey: String, query: String) = viewModelScope.launch {
        movieListUseCase(apiKey, query).onEach {
            when (it) {
                is UiEvent.Loading -> {
                    _movieList.value = MovieSearchStateHolder(isLoading = true)
                }

                is UiEvent.Error -> {
                    _movieList.value = MovieSearchStateHolder(error = it.message)
                }

                is UiEvent.Success -> {
                    _movieList.value = MovieSearchStateHolder(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onQueryChanged(query: String) {
        _query.value = query
    }
}