package com.example.moviesapp_modularized

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.moviesapp_modularized.navigation.AppNavGraph
import com.example.moviesapp_modularized.navigation.NavigationProvider
import com.example.moviesapp_modularized.ui.theme.Moviesapp_modularizedTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationProvider: NavigationProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            App(
                navHostController = navController,
                navigationProvider = navigationProvider
            )
        }
    }
}

@Composable
fun App(navHostController: NavHostController, navigationProvider: NavigationProvider) {
    Moviesapp_modularizedTheme {
        ScaffoldDefaults.contentWindowInsets // Fixes blank screen for Xiaomi devices
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            AppNavGraph(navController = navHostController, navigationProvider = navigationProvider)
        }
    }
}