package com.example.espresso.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.request.RequestOptions
import com.example.espresso.R
import com.example.espresso.data.source.MoviesDataSource
import com.example.espresso.data.source.MoviesRemoteDataSource
import com.example.espresso.factory.MovieFragmentFactory
import com.example.espresso.ui.fragment.MovieDetailFragment
import com.example.espresso.ui.fragment.MovieListFragment

class MainActivity : AppCompatActivity() {

    lateinit var requestOptions: RequestOptions
    lateinit var moviesDataSource: MoviesDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        initDependencies()
        supportFragmentManager.fragmentFactory = MovieFragmentFactory(
            requestOptions,
            moviesDataSource
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        if (supportFragmentManager.fragments.size == 0) {
            val movieId = 1
            val bundle = Bundle()
            bundle.putInt("movie_id", movieId)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MovieListFragment::class.java, bundle)
                .commit()
        }
    }


    private fun initDependencies() {
        if (!::requestOptions.isInitialized) {
            // glide
            requestOptions = RequestOptions
                .placeholderOf(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
        }
        if (!::moviesDataSource.isInitialized) {
            // Data Source
            moviesDataSource = MoviesRemoteDataSource()
        }
    }
}
