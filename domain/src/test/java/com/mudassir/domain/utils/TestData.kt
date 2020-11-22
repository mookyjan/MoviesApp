package com.mudassir.domain.utils

import com.mudassir.domain.entity.MovieDetailEntity
import com.mudassir.domain.entity.MovieListEntity
import com.mudassir.domain.entity.MovieEntity


//TODO this is dummy data only for checking , will add all the fields to check thoroughly
fun getTestMovieEntity(id: Int): MovieEntity {
    return MovieEntity(
        popularity = 3.4,
        id = id,
        title = "Movie$id",
        originalTitle = "Movie$id",
        backdropPath = "",
        posterPath = "",
        originalLanguage = "",
        releaseDate = "")
}

fun generateMovieEntityList(): List<MovieEntity> {
    return (0..4).map { getTestMovieEntity(it) }
}

fun getTestMovieDetail(id:Int): MovieDetailEntity{
    return MovieDetailEntity(
        id =id,
        adult = false,
        backdropPath = "",
        homepage = "homepage"
    )
}