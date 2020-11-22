package com.mudassir.domain.entity


data class MovieListEntity(
    var page: Int? = null,
    var totalResults: Int? = null,
    var totalPages: Int? = null,
    val movieList: List<MovieEntity> ?= emptyList()
)

