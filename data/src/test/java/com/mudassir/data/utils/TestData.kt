package com.mudassir.data.utils

import com.mudassir.data.remote.model.*
import com.mudassir.domain.entity.MovieDetailEntity
import com.mudassir.domain.entity.MovieListEntity

object TestData {

    internal fun getProductionCompany():ProductionCompany
            = ProductionCompany(id = 13,logoPath = "",name = "Netflix",originCountry = "US")

    internal fun getProductionCountry(): ProductionCountry
    = ProductionCountry(iso31661 = "23xdf",name = "US")

    internal fun getBelongCollection()
    = BelongsToCollection(id = 1,name = "Star",posterPath = "")

    internal fun getMovieModel(popularity:Double =3.8,id:Int =12,title: String="Star War") =
        MovieModel(popularity,id=id,title = title,backdropPath = "",posterPath = "",releaseDate ="" ,overview = "")

   internal fun getMovieDetailResponse() =
       MovieDetailResponse(adult= false,id = 100,backdropPath = "", homepage = "homepage")

   internal fun getTestMovieDetail(id:Int): MovieDetailEntity {
        return MovieDetailEntity(
            id =id,
            adult = false,
            backdropPath = "",
            homepage = "homepage"
        )
    }

}
