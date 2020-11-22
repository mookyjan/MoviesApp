package com.mudassir.moviesapp.utils

import com.mudassir.domain.entity.MovieDetailEntity


object TestData {

    //TODO update this model for testing later
    fun getTestMovieDetail(id:Int): MovieDetailEntity {
        return MovieDetailEntity(
            id =id,
            adult = false,
            backdropPath = "",
            homepage = "homepage"
        )
    }
}