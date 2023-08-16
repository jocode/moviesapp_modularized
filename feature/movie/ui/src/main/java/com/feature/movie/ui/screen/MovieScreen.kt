package com.feature.movie.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.feature.movie.domain.model.Movie

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun MovieScreen(
    viewModel: MovieSearchViewModel,
    onNavigateToMovieDetailsScreen: (String) -> Unit,
) {
    val result = viewModel.movieList.value
    val query = viewModel.query.collectAsState()

    val focusManager = LocalFocusManager.current


    Scaffold(
        topBar = {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = query.value,
                onValueChange = { viewModel.onQueryChanged(it) },
                placeholder = {
                    Text(text = "Search movie")
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "search"
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                ),
            )
        }
    ) { paddingValues ->

        if (result.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        if (result.error.isNotBlank()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = result.error)
            }
        }

        if (result.data.isNotEmpty()) {
            // Hide the keyboard when the list is shown
            focusManager.clearFocus()

            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 128.dp),
                contentPadding = paddingValues
            ) {
                items(result.data) { movie ->
                    MovieItem(
                        modifier = Modifier.clickable {
                            onNavigateToMovieDetailsScreen(movie.id.toString())
                        },
                        movie = movie
                    )
                }
            }
        } else {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "No data")
            }
        }

    }
}

@Composable
fun MovieItem(
    modifier: Modifier = Modifier,
    movie: Movie,
) {
    Box(
        modifier = modifier
            .height(200.dp)
            .border(width = 1.dp, color = Color.White)
    ) {
        AsyncImage(
            model = movie.posterPath,
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
    }
}