package com.mudassir.moviesapp.ui.detail

import com.squareup.moshi.Json

class MovieDetailModel (
    var adult: Boolean? = null,
    var backdropPath: String? = null,
    var belongsToCollection: BelongsToCollectionModel? = null,
    var budget: Int? = null,
    var genres: List<GenreModel>? = null,
    var homepage: String? = null,
    var id: Int? = null,
    var imdbId: String? = null,
    var originalLanguage: String? = null,
    var originalTitle: String? = null,
    var overview: String? = null,
    var popularity: Double? = null,
    var posterPath: String? = null,
    var productionCompanies: List<ProductionCompanyModel>? = null,
    var productionCountries: List<ProductionCountryModel>? = null,
    var releaseDate: String? = null,
    var revenue: Int? = null,
    var runtime: Int? = null,
    var spokenLanguages: List<SpokenLanguageModel>? = null,
    var status: String? = null,
    var tagline: String? = null,
    var title: String? = null,
    var video: Boolean? = null,
    var voteAverage: Double? = null,
    var voteCount: Int? = null
)


data class BelongsToCollectionModel(
    var id: Int? = null,
    var name: String? = null,
    var posterPath: String? = null,
    var backdropPath: String? = null
)

data class GenreModel(
    var id: Int? = null,
    var name: String? = null
)


data class ProductionCompanyModel(
    var id: Int? = null,
    var logoPath: String? = null,
    var name: String? = null,
    var originCountry: String? = null
)


data class ProductionCountryModel(
    var iso31661: String? = null,
    var name: String? = null
)


data class SpokenLanguageModel(
    var englishName: String? = null,
    var iso6391: String? = null,
    var name: String? = null
)
