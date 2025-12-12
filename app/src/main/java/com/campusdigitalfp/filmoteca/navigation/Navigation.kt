package com.campusdigitalfp.filmoteca.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.campusdigitalfp.filmoteca.AboutScreen
import com.campusdigitalfp.filmoteca.screens.Film
import com.campusdigitalfp.filmoteca.screens.FilmDataScreen
import com.campusdigitalfp.filmoteca.screens.FilmEditScreen
import com.campusdigitalfp.filmoteca.screens.FilmListScreen
import com.campusdigitalfp.filmoteca.screens.oldFilmEditScreen

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
        composable("editar/{id}"){ backStackEntry ->
            val id=backStackEntry.arguments?.getInt("id")
            if (id!=null)
               FilmEditScreen(navController, id)
        }
        composable(route = "datosfilm/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")
            if (id != null) {
                FilmDataScreen(navController, id)
            }
        }
    }
}


