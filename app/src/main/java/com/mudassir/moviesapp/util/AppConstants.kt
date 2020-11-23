package com.mudassir.moviesapp.util

object AppConstants {

    const val MOVIE_ARGU ="movie"
    private const val BASE_POSTER_PATH = "https://image.tmdb.org/t/p/w342"
    private const val BASE_BACKDROP_PATH = "https://image.tmdb.org/t/p/w780"
    const val WEB_VIEW_URL ="https://www.cathaycineplexes.com.sg/"

    /** gets the poster's path. */
    fun getPosterPath(posterPath: String) = BASE_POSTER_PATH + posterPath

    /** gets the back drop's path. */
    fun getBackdropPath(backdropPath: String?) = BASE_BACKDROP_PATH + backdropPath
}