package com.campusdigitalfp.filmoteca.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.campusdigitalfp.filmoteca.AboutScreen
import com.campusdigitalfp.filmoteca.Datos.FilmDataSource.films
import com.campusdigitalfp.filmoteca.screens.Film
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
        composable ("lista"){
            FilmListScreen(navController = navController)}
        //composable ("editar"){ FilmEditScreen(navController) }
        composable("editar/{idfilm}") { backStackEntry ->
            val idfilm = backStackEntry.arguments?.getString("idfilm")?.toIntOrNull()
            val film = films.find {it.id==idfilm}
            film?.let{
                FilmEditScreen(navController, it)
            }
        }
        composable(route = "datosfilm/{idfilm}")
               { backStackEntry ->
            val idfilm = backStackEntry.arguments?.getString("idfilm")?.toIntOrNull()
            val film = films.find {it.id==idfilm}
            film?.let{
                FilmDataScreen(navController, it)
            }
        }


    }
}


