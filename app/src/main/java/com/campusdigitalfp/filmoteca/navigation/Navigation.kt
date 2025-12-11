package com.campusdigitalfp.filmoteca.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.campusdigitalfp.filmoteca.AboutScreen
import com.campusdigitalfp.filmoteca.screens.FilmDataScreen
import com.campusdigitalfp.filmoteca.screens.FilmEditScreen
import com.campusdigitalfp.filmoteca.screens.FilmListScreen

@Composable
fun Navigation ()
{
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "lista")
    {
        composable ("about") {AboutScreen(navController)}
        composable ("lista"){ FilmListScreen(navController) }
        //composable ("editar"){ FilmEditScreen(navController) }
        composable("editar/{titulo}"){backStackEntry ->
            val titulo=backStackEntry.arguments?.getString("titulo")
            if (titulo!=null)
                FilmEditScreen(navController,titulo)
        }
        composable("datosfilm/{titulo}") { backStackEntry ->
            val titulo = backStackEntry.arguments?.getString("titulo")
            if (titulo != null) {
                FilmDataScreen(navController, titulo)
            }
        }

    }
}