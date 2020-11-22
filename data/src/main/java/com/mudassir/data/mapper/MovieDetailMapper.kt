package com.mudassir.data.mapper

import com.mudassir.data.remote.model.MovieDetailResponse
import com.mudassir.data.util.BaseMapper
import com.mudassir.domain.entity.*

object  MovieDetailToDomainMapper : BaseMapper<MovieDetailEntity,MovieDetailResponse>() {

    override fun transformFrom(source: MovieDetailResponse): MovieDetailEntity {
       return MovieDetailEntity(adult = false,backdropPath = source.backdropPath,
           belongsToCollection = source.belongsToCollection?.let {
               BelongsToCollectionToDomainMapper.transformFrom(it)
           },
           budget = source.budget,genres =  source.genres?.let {GenretoDomainMapper.transformFromList(it)} ,
           homepage = source.homepage,id = source.id,
           imdbId = source.imdbId,originalLanguage = source.originalLanguage,originalTitle = source.originalTitle,
           overview = source.overview,popularity = source.popularity,posterPath = source.posterPath,
           productionCompanies = source.productionCompanies?.let {
               ProductionCompaniesToDomainMapper.transformFromList(it)
           },
               productionCountries = source.productionCountries?.let {
                   ProductionCountryToDomainMapper.transformFromList(it)
               },
               releaseDate = source.releaseDate,revenue = source.revenue,runtime = source.runtime,
               spokenLanguages = source.spokenLanguages?.let {
                   SpokenLanguageToDomainMapper.transformFromList(it)
               },
               status = source.status,tagline = source.tagline,
               title = source.title,video = source.video,voteAverage = source.voteAverage,voteCount = source.voteCount
               )
           }


    override fun transformTo(source: MovieDetailEntity): MovieDetailResponse {
       return MovieDetailResponse(adult = false,backdropPath = source.backdropPath,
           belongsToCollection = source.belongsToCollection?.let {
               BelongsToCollectionToDomainMapper.transformTo(it)
           },
               budget = source.budget,genres = source.genres?.let {
               GenretoDomainMapper.transformToList(it)
           } ,
               homepage = source.homepage,id = source.id,
               imdbId = source.imdbId,originalLanguage = source.originalLanguage,originalTitle = source.originalTitle,
               overview = source.overview,popularity = source.popularity,posterPath = source.posterPath,
               productionCompanies = source.productionCompanies?.let {
                   ProductionCompaniesToDomainMapper.transformToList(it)
               },
               productionCountries =source.productionCountries?.let {
                   ProductionCountryToDomainMapper.transformToList(it)
               },
               releaseDate = source.releaseDate,revenue = source.revenue,runtime = source.runtime,
               spokenLanguages = source.spokenLanguages?.let {
                   SpokenLanguageToDomainMapper.transformToList(it)
               } ,status = source.status,tagline = source.tagline,
               title = source.title,video = source.video,voteAverage = source.voteAverage,voteCount = source.voteCount)
           }
    }



object BelongsToCollectionToDomainMapper : BaseMapper<BelongsToCollection,com.mudassir.data.remote.model.BelongsToCollection>(){

    override fun transformFrom(source: com.mudassir.data.remote.model.BelongsToCollection): BelongsToCollection {
        return BelongsToCollection(id = source.id,name = source.name,posterPath = source.posterPath,
            backdropPath = source.backdropPath)
    }

    override fun transformTo(source: BelongsToCollection): com.mudassir.data.remote.model.BelongsToCollection {
      return com.mudassir.data.remote.model.BelongsToCollection(id = source.id,name = source.name,
          posterPath = source.posterPath, backdropPath = source.backdropPath)
    }

}


object GenretoDomainMapper: BaseMapper<Genre,com.mudassir.data.remote.model.Genre>(){

    override fun transformFrom(source: com.mudassir.data.remote.model.Genre): Genre {
        return Genre(id = source.id,name = source.name)
    }

    override fun transformTo(source: Genre): com.mudassir.data.remote.model.Genre {
        return com.mudassir.data.remote.model.Genre(id = source.id,name = source.name)
    }

}

object ProductionCompaniesToDomainMapper : BaseMapper<ProductionCompany,com.mudassir.data.remote.model.ProductionCompany>(){

    override fun transformFrom(source: com.mudassir.data.remote.model.ProductionCompany): ProductionCompany {
        return ProductionCompany(id = source.id,logoPath = source.logoPath,name = source.name,originCountry = source.originCountry)
    }

    override fun transformTo(source: ProductionCompany): com.mudassir.data.remote.model.ProductionCompany {
       return com.mudassir.data.remote.model.ProductionCompany(id = source.id,logoPath = source.logoPath,name = source.name,originCountry = source.originCountry)
    }

}

object ProductionCountryToDomainMapper : BaseMapper<ProductionCountry,com.mudassir.data.remote.model.ProductionCountry>(){

    override fun transformFrom(source: com.mudassir.data.remote.model.ProductionCountry): ProductionCountry {
       return ProductionCountry(iso31661 = source.iso31661,name = source.name)
    }

    override fun transformTo(source: ProductionCountry): com.mudassir.data.remote.model.ProductionCountry {
       return  com.mudassir.data.remote.model.ProductionCountry(iso31661 = source.iso31661,name = source.name)
    }

}

object SpokenLanguageToDomainMapper: BaseMapper<SpokenLanguage,com.mudassir.data.remote.model.SpokenLanguage>(){

    override fun transformFrom(source: com.mudassir.data.remote.model.SpokenLanguage): SpokenLanguage {

       return SpokenLanguage(englishName = source.englishName,iso6391 = source.iso6391,name = source.name)
    }

    override fun transformTo(source: SpokenLanguage): com.mudassir.data.remote.model.SpokenLanguage {

        return com.mudassir.data.remote.model.SpokenLanguage(englishName = source.englishName,
            iso6391 = source.iso6391,name = source.name)
    }


}

