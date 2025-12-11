package com.campusdigitalfp.filmoteca.Datos

import com.campusdigitalfp.filmoteca.R
import com.campusdigitalfp.filmoteca.screens.Film


object FilmDataSource {
    val films: MutableList<Film> = mutableListOf()

    init {
        // Primera película: Harry Potter y la piedra filosofal
        val f1 = Film()
        f1.id = films.size
        f1.title = "El silencio de los corderos"
        f1.director = "Jonathan Demme"
        f1.imageResId = R.drawable.elsilenciodeloscorderos
        f1.comments = "Sin lugar a dudas, el thriller de los años noventa."
        f1.format = Film.FORMAT_DVD
        f1.genre = Film.GENRE_HORROR // Cambia según corresponda
        f1.imdbUrl = "https://m.imdb.com/es-es/title/tt0102926"
        f1.year = 1991
        films.add(f1)

        // Segunda película: Regreso al futuro
        val f2 = Film()
        f2.id = films.size
        f2.title = "Regreso al futuro"
        f2.director = "Robert Zemeckis"
        f2.imageResId = R.drawable.regresoalfuturo
        f2.comments = ""
        f2.format = Film.FORMAT_DIGITAL
        f2.genre = Film.GENRE_SCIFI
        f2.imdbUrl = "http://www.imdb.com/title/tt0088763"
        f2.year = 1985
        films.add(f2)

        // Tercera película: El rey león
        val f3 = Film()
        f3.id = films.size
        f3.title = "El rey león"
        f3.director = "Roger Allers, Rob Minkoff"
        f3.imageResId = R.drawable.elreyleon
        f3.comments = "Una historia de crecimiento y responsabilidad."
        f3.format = Film.FORMAT_BLURAY
        f3.genre = Film.GENRE_ACTION // Cambia según corresponda
        f3.imdbUrl = "http://www.imdb.com/title/tt0110357"
        f3.year = 1994
        films.add(f3)

        // Añade más películas si deseas!
    }
}