package com.campusdigitalfp.filmoteca.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.campusdigitalfp.filmoteca.AboutScreen
import com.campusdigitalfp.filmoteca.screens.FilmListScreen

@Composable
fun Navigation ()
{
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "lista")
    {
        composable ("inicio") {AboutScreen(navController)}
        composable ("lista"){ FilmListScreen(navController) }

    }
}