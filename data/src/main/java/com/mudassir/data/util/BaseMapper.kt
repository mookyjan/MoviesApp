package com.mudassir.data.util

import com.mudassir.data.remote.model.MovieModel
import com.mudassir.data.remote.model.mapToDomain
import com.mudassir.domain.entity.MovieEntity

abstract class BaseMapper<T, K> {

    abstract fun transformFrom(source: K): T

    abstract fun transformTo(source: T): K

    fun transformFromList(source: List<K>?): List<T> {
        return source?.map { src -> transformFrom(src) } ?: emptyList()
    }
    fun transformToList(source: List<T>): List<K> {
        return source.map { src -> transformTo(src) }
    }

    fun List<MovieModel>.mapLisToDomain() : List<MovieEntity>
            = map { it.mapToDomain() }

    fun toList(source: List<T>):List<K> = source.map { src -> transformTo(src) }

}