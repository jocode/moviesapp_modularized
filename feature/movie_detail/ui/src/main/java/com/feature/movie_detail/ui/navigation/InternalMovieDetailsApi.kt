package com.feature.movie_detail.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.core.common.navigation_constants.MovieDetailsFeature
import com.core.feature_api.FeatureApi

object InternalMovieDetailsApi : FeatureApi {
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation(
            startDestination = MovieDetailsFeature.movieDetailsScreenRoute,
            route = MovieDetailsFeature.nestedRoute
        ) {
            composable(MovieDetailsFeature.movieDetailsScreenRoute) {
                val id = it.arguments?.getString("id")

            }
        }
    }
}