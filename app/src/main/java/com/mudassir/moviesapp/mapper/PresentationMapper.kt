package com.mudassir.moviesapp.mapper

import com.mudassir.data.mapper.*
import com.mudassir.data.util.BaseMapper
import com.mudassir.domain.entity.*
import com.mudassir.moviesapp.ui.detail.*

object MovieDetailDomainToPresentation : BaseMapper<MovieDetailEntity, MovieDetailModel>(){

    override fun transformFrom(source: MovieDetailModel): MovieDetailEntity {
        return MovieDetailEntity(adult = false,backdropPath = source.backdropPath,
            belongsToCollection = BelongsToCollectionDomainToPresentation.transformFrom(source.belongsToCollection!!),
            budget = source.budget,genres =  source.genres?.let {
                GenretoDomainToPresentation.transformFromList(it)
            },
                homepage = source.homepage,id = source.id,
                imdbId = source.imdbId,originalLanguage = source.originalLanguage,originalTitle = source.originalTitle,
                overview = source.overview,popularity = source.popularity,posterPath = source.posterPath,
                productionCompanies = source.productionCompanies?.let {
                    ProductionCompaniesDomainToPresentation.transformFromList(it)
                },
                    productionCountries = source.productionCountries?.let {
                        ProductionCountryDomainToPresentation.transformFromList(it)
                    },
                        releaseDate = source.releaseDate,revenue = source.revenue,runtime = source.runtime,
                        spokenLanguages = source.spokenLanguages?.let {
                            SpokenLanguageDomainToPresentation.transformFromList(it)
                        },
                        status = source.status,tagline = source.tagline,
                        title = source.title,video = source.video,voteAverage = source.voteAverage,voteCount = source.voteCount)
                    }



    override fun transformTo(source: MovieDetailEntity): MovieDetailModel {
        return MovieDetailModel(adult = false,backdropPath = source.backdropPath,
            belongsToCollection =source.belongsToCollection?.let {
                BelongsToCollectionDomainToPresentation.transformTo(it)
            } ,
            budget = source.budget,genres =  source.genres?.let {
                GenretoDomainToPresentation.transformToList(it)
            },
            homepage = source.homepage,id = source.id,
            imdbId = source.imdbId,originalLanguage = source.originalLanguage,originalTitle = source.originalTitle,
            overview = source.overview,popularity = source.popularity,posterPath = source.posterPath,
            productionCompanies = source.productionCompanies?.let {
                ProductionCompaniesDomainToPresentation.transformToList(it)
            },
            productionCountries = source.productionCountries?.let{
                ProductionCountryDomainToPresentation.transformToList(it)
            },
            releaseDate = source.releaseDate,revenue = source.revenue,runtime = source.runtime,
            spokenLanguages = source.spokenLanguages?.let {
                SpokenLanguageDomainToPresentation.transformToList(it)
            },status = source.status,tagline = source.tagline,
            title = source.title,video = source.video,voteAverage = source.voteAverage,voteCount = source.voteCount)
    }



object BelongsToCollectionDomainToPresentation : BaseMapper<BelongsToCollection,BelongsToCollectionModel>(){

    override fun transformFrom(source: BelongsToCollectionModel): BelongsToCollection {
        return BelongsToCollection(id = source.id,name = source.name,posterPath = source.posterPath,
            backdropPath = source.backdropPath)
    }

    override fun transformTo(source: BelongsToCollection):BelongsToCollectionModel {
        return BelongsToCollectionModel(id = source.id,name = source.name,
            posterPath = source.posterPath, backdropPath = source.backdropPath)
    }

}


object GenretoDomainToPresentation: BaseMapper<Genre,GenreModel>(){

    override fun transformFrom(source: GenreModel): Genre {
        return Genre(id = source.id,name = source.name)
    }

    override fun transformTo(source: Genre): GenreModel {
        return GenreModel(id = source.id,name = source.name)
    }

}

object ProductionCompaniesDomainToPresentation : BaseMapper<ProductionCompany,ProductionCompanyModel>(){

    override fun transformFrom(source: ProductionCompanyModel): ProductionCompany {
        return ProductionCompany(id = source.id,logoPath = source.logoPath,name = source.name,originCountry = source.originCountry)
    }

    override fun transformTo(source: ProductionCompany): ProductionCompanyModel {
        return ProductionCompanyModel(id = source.id,logoPath = source.logoPath,name = source.name,originCountry = source.originCountry)
    }

}

object ProductionCountryDomainToPresentation : BaseMapper<ProductionCountry,ProductionCountryModel>(){

    override fun transformFrom(source: ProductionCountryModel): ProductionCountry {
        return ProductionCountry(iso31661 = source.iso31661,name = source.name)
    }

    override fun transformTo(source: ProductionCountry): ProductionCountryModel {
        return  ProductionCountryModel(iso31661 = source.iso31661,name = source.name)
    }

}

object SpokenLanguageDomainToPresentation: BaseMapper<SpokenLanguage,SpokenLanguageModel>() {

    override fun transformFrom(source: SpokenLanguageModel): SpokenLanguage {

        return SpokenLanguage(
            englishName = source.englishName,
            iso6391 = source.iso6391,
            name = source.name
        )
    }

    override fun transformTo(source: SpokenLanguage): SpokenLanguageModel {

        return SpokenLanguageModel(
            englishName = source.englishName,
            iso6391 = source.iso6391, name = source.name
        )
    }

}
}