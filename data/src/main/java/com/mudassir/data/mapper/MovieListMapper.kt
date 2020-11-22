package com.mudassir.data.mapper

import com.mudassir.data.remote.model.MovieModel
import com.mudassir.data.remote.model.MovieResponse
import com.mudassir.data.util.BaseMapper
import com.mudassir.domain.entity.MovieListEntity

object MovieListToDomainMapper: BaseMapper<MovieListEntity, MovieResponse>() {

    override fun transformFrom(source: MovieResponse): MovieListEntity {

        return MovieListEntity(movieList = MovieModelToDomainMapper.transformToList(source.results!!))
    }
    override fun transformTo(source: MovieListEntity): MovieResponse
            = MovieResponse(results = source.movieList?.let {
        MovieModelToDomainMapper.transformFromList(
            it
        )
    })
}

object MovieModelToDomainMapper: BaseMapper<MovieModel, com.mudassir.domain.entity.MovieEntity>(){

    override fun transformFrom(source: com.mudassir.domain.entity.MovieEntity): MovieModel
            = MovieModel(popularity = source.popularity,id = source.id,video =source.video, voteCount=source.voteCount,
        voteAverage=source.voteAverage, title=source.title, releaseDate=source.releaseDate,
        originalLanguage=source.originalLanguage, originalTitle=source.originalTitle, genreIds=source.genreIds,
        backdropPath=source.backdropPath, adult=source.adult, overview=source.overview, posterPath=source.posterPath)

    override fun transformTo(source: MovieModel): com.mudassir.domain.entity.MovieEntity
            = com.mudassir.domain.entity.MovieEntity(popularity = source.popularity,id = source.id!!,video =source.video, voteCount=source.voteCount,
        voteAverage=source.voteAverage, title=source.title, releaseDate=source.releaseDate,
        originalLanguage=source.originalLanguage, originalTitle=source.originalTitle, genreIds=source.genreIds,
        backdropPath=source.backdropPath, adult=source.adult, overview=source.overview, posterPath=source.posterPath)
}