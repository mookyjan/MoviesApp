package com.mudassir.data.remote.model

import com.squareup.moshi.Json

data class MovieResponse(
    @Json(name = "page")
    var page: Int? = null,

    @Json(name = "total_results")
    var totalResults: Int? = null,

    @Json(name = "total_pages")
    var totalPages: Int? = null,

    @Json(name = "results")
    var results: List<MovieModel>? = null
)

data class MovieModel(
    @Json(name = "popularity")
    var popularity: Double? = null,

    @Json(name = "id")
    var id: Int? = null,

    @Json(name = "video")
    var video: Boolean? = null,

    @Json(name = "vote_count")
    var voteCount: Int? = null,

    @Json(name = "vote_average")
    var voteAverage: Double? = null,

    @Json(name = "title")
    var title: String? = null,

    @Json(name = "release_date")
    var releaseDate: String? = null,

    @Json(name = "original_language")
    var originalLanguage: String? = null,

    @Json(name = "original_title")
    var originalTitle: String? = null,

    @Json(name = "genre_ids")
    var genreIds: List<Int>? = null,

    @Json(name = "backdrop_path")
    var backdropPath: String? = null,

    @Json(name = "adult")
    var adult: Boolean? = null,

    @Json(name = "overview")
    var overview: String? = null,

    @Json(name = "poster_path")
    var posterPath: String? = null
)


fun MovieModel.mapToDomain() : com.mudassir.domain.entity.MovieEntity
  = com.mudassir.domain.entity.MovieEntity( id=id!!,popularity = popularity )
