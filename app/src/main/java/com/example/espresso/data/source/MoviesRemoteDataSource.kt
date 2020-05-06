package com.example.espresso.data.source

import com.example.espresso.data.DummyMovies
import com.example.espresso.data.Movie


class MoviesRemoteDataSource : MoviesDataSource {

    private var MOVIES_REMOTE_DATA = LinkedHashMap<Int, Movie>(DummyMovies.movies.size)

    init {
        for (movie in DummyMovies.movies) {
            addMovie(movie)
        }
    }

    override fun getMovies(): List<Movie> {
        return ArrayList(MOVIES_REMOTE_DATA.values)
    }

    override fun getMovie(movieId: Int): Movie {
        return MOVIES_REMOTE_DATA[movieId]!!
    }

    private fun addMovie(
        movie: Movie
    ) {
        MOVIES_REMOTE_DATA.put(movie.id, movie)
    }

}