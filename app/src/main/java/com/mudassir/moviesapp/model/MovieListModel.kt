package com.mudassir.moviesapp.model

import com.mudassir.domain.entity.MovieEntity
import com.mudassir.domain.entity.MovieListEntity

data class MovieListModel(
    val movieList: List<Movie>
)

data class Movie(

    var popularity: Double? = null,


    var id: Int,


    var video: Boolean? = null,


    var voteCount: Int? = null,

    var voteAverage: Double? = null,


    var title: String? = null,


    var releaseDate: String? = null,


    var originalLanguage: String? = null,


    var originalTitle: String? = null,

    var genreIds: List<Int>? = null,


    var backdropPath: String? = null,


    var adult: Boolean? = null,


    var overview: String? = null,


    var posterPath: String? = null
)

fun com.mudassir.domain.entity.MovieEntity.mapToPresentation(): Movie
        = Movie(popularity, id, video, voteCount, voteAverage, title, releaseDate, originalLanguage, originalTitle, genreIds, backdropPath, adult, overview, posterPath)

fun List<com.mudassir.domain.entity.MovieEntity>.mapToPresentation(): List<Movie>
        = map { it.mapToPresentation() }
fun MovieListEntity.mapToPresentation() : MovieListModel
        = MovieListModel(movieList = movieList.mapToPresentation())