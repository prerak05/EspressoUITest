package com.example.espresso.factory

import androidx.fragment.app.FragmentFactory
import com.example.espresso.ui.fragment.DirectorsFragment
import com.example.espresso.ui.fragment.MovieDetailFragment
import com.example.espresso.ui.fragment.StarActorsFragment

class MovieFragmentFactory : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String) =
        when (className) {
            MovieDetailFragment::class.java.name -> {
                MovieDetailFragment()
            }
            DirectorsFragment::class.java.name -> {
                DirectorsFragment()
            }
            StarActorsFragment::class.java.name -> {
                StarActorsFragment()
            }
            else -> {
                super.instantiate(classLoader, className)
            }
        }
}