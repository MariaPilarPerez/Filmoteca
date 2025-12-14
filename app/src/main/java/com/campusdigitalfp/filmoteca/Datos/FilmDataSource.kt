package com.campusdigitalfp.filmoteca.Datos

import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import com.campusdigitalfp.filmoteca.R
import com.campusdigitalfp.filmoteca.screens.Film


object FilmDataSource {
    val films = mutableStateListOf<Film>()
    fun loadData(context: Context) {
        // Primera película: el silencio de los corderos
        val f1 = Film(
            id = films.size,
            title = "El silencio de los corderos",
            director = "Jonathan Demme",
            imageResId = R.drawable.elsilenciodeloscorderos,
            comments = "Sin lugar a dudas, el thriller de los años noventa.",
            format = Film.FORMAT_DVD,
            genre = Film.GENRE_HORROR, // Cambia según corresponda,
            imdbUrl = "https://m.imdb.com/es-es/title/tt0102926",
            year = 1991
        )
        films.add(f1)

        // Segunda película: Regreso al futuro
        val f2 = Film(
            id = films.size,
            title = "Regreso al futuro",
            director = "Robert Zemeckis",
            imageResId = R.drawable.regresoalfuturo,
            comments = "Aventuras en el pasado y el futuro",
            format = Film.FORMAT_DIGITAL,
            genre = Film.GENRE_SCIFI,
            imdbUrl = "http://www.imdb.com/title/tt0088763",
            year = 1985
        )
        films.add(f2)

        // Tercera película: Interstellar
        val f3 = Film(
            id = films.size,
            title = "Interestelar",
            director = "Christopher Nolan",
            imageResId = R.drawable.interstellar,
            comments = "Fascinante, una aventura interespacial",
            format = Film.FORMAT_BLURAY,
            genre = Film.GENRE_SCIFI, // Cambia según corresponda
            imdbUrl = "https://m.imdb.com/es-es/title/tt0816692",
            year = 2014
        )
        films.add(f3)

        val f4 = Film(
            id = films.size,
            title = "Love Actually",
            director = "Richard Curtis",
            imageResId = R.drawable.loveactually,
            comments = "La comedia romántica del año",
            format = Film.FORMAT_DVD,
            genre = Film.GENRE_COMEDY, // Cambia según corresponda
            imdbUrl = "https://www.imdb.com/es-es/title/tt0314331",
            year = 2003
        )
        films.add(f4)

        val f5 = Film(
            id = films.size,
            title = "Harry Potter y la piedra filosofal",
            director = "Chris Columbus",
            imageResId = R.drawable.harrypotter,
            comments = "Una aventura mágica en Hogwarts.",
            format = Film.FORMAT_DVD,
            genre = Film.GENRE_ACTION, // Cambia según corresponda
            imdbUrl = "http://www.imdb.com/title/tt0241527",
            year = 2001
        )
        films.add(f5)

        // Tercera película: El rey león
        val f6 = Film(
            id = films.size,
            title = "El rey león",
            director = "Roger Allers, Rob Minkoff",
            imageResId = R.drawable.elreyleon,
            comments = "Una historia de crecimiento y responsabilidad.",
            format = Film.FORMAT_BLURAY,
            genre = Film.GENRE_ACTION, // Cambia según corresponda
            imdbUrl = "https://www.imdb.com/es-es/title/tt0110357",
            year = 1994
        )
        films.add(f6)


        // Añade más películas si deseas!
    }
}