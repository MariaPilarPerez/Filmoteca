package com.campusdigitalfp.filmoteca.Datos

import com.campusdigitalfp.filmoteca.R
import com.campusdigitalfp.filmoteca.screens.Film


object FilmDataSource {
    val films: MutableList<Film> = mutableListOf()

    init {
        // Primera película: el silencio de los corderos
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

        // Tercera película: Interstellar
        val f3 = Film()
        f3.id = films.size
        f3.title = "Interestelar"
        f3.director = "Christopher Nolan"
        f3.imageResId = R.drawable.interstellar
        f3.comments = "Fascinante, una aventura interespacial"
        f3.format = Film.FORMAT_BLURAY
        f3.genre = Film.GENRE_SCIFI // Cambia según corresponda
        f3.imdbUrl = "https://m.imdb.com/es-es/title/tt0816692"
        f3.year = 2014
        films.add(f3)

        val f4 = Film()
        f4.id = films.size
        f4.title = "Love Actually"
        f4.director = "Richard Curtis"
        f4.imageResId = R.drawable.loveactually
        f4.comments = "La comedia romántica del año"
        f4.format = Film.FORMAT_DVD
        f4.genre = Film.GENRE_COMEDY // Cambia según corresponda
        f4.imdbUrl = "https://m.imdb.com/es-es/title/tt0816692"
        f4.year = 2003
        films.add(f4)

        val f5 = Film()
        f5.id = films.size
        f5.title = "Harry Potter y la piedra filosofal"
        f5.director = "Chris Columbus"
        f5.imageResId = R.drawable.harrypotter
        f5.comments = "Una aventura mágica en Hogwarts."
        f5.format = Film.FORMAT_DVD
        f5.genre = Film.GENRE_ACTION // Cambia según corresponda
        f5.imdbUrl = "http://www.imdb.com/title/tt0241527"
        f5.year = 2001
        films.add(f5)

        // Tercera película: El rey león
        val f6 = Film()
        f6.id = films.size
        f6.title = "El rey león"
        f6.director = "Roger Allers, Rob Minkoff"
        f6.imageResId = R.drawable.elreyleon
        f6.comments = "Una historia de crecimiento y responsabilidad."
        f6.format = Film.FORMAT_BLURAY
        f6.genre = Film.GENRE_ACTION // Cambia según corresponda
        f6.imdbUrl = "http://www.imdb.com/title/tt0110357"
        f6.year = 1994
        films.add(f6)





        // Añade más películas si deseas!
    }
}