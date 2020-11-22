package com.mudassir.domain.entity

data class MovieEntity(
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