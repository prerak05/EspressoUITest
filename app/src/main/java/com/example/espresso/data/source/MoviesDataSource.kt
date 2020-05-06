package com.example.espresso.data.source

import com.example.espresso.data.Movie

interface MoviesDataSource {

    fun getMovie(movieId: Int): Movie

    fun getMovies(): List<Movie>
}