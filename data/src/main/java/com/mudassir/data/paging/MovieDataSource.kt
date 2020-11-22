package com.mudassir.data.paging

import androidx.paging.rxjava2.RxPagingSource
import com.mudassir.data.local.mapper.MovieListToDomainMapper
import com.mudassir.data.repository.MovieListRepository
import com.mudassir.domain.entity.MovieEntity
import com.mudassir.domain.entity.MovieListEntity
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import java.io.IOException
import java.io.InvalidObjectException

class MovieDataSource (val movieService: MovieListRepository): RxPagingSource<Int, MovieEntity>()  {

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, MovieEntity>> {
        val page = params.key ?: 1
        return try {
            val response = movieService.getMovieList(false,page)
                .subscribeOn(Schedulers.io())
            response.map {
                val mapResponse =  MovieListToDomainMapper.transformFrom(it)
                toLoadResult(mapResponse,page)
            }.onErrorReturn {
                LoadResult.Error(it)
            }

        } catch (exception: IOException) {
            Single.just(LoadResult.Error(exception))
        } catch (exception: HttpException) {
            Single.just(LoadResult.Error(exception))
        } catch (exception: InvalidObjectException) {
            Single.just(LoadResult.Error(exception))
        } catch (exception: Exception) {
            Single.just(LoadResult.Error(exception))
        }

    }

    private fun toLoadResult(data: MovieListEntity, position: Int): LoadResult<Int, MovieEntity> {

        return LoadResult.Page(
            data = data.movieList ?: listOf(),
            prevKey = if (position == 1) null else position - 1,
            nextKey = if (position == data.totalPages) null else position + 1
        )
    }

//    @ExperimentalPagingApi
//    override fun getRefreshKey(state: PagingState<Int, MovieResponse>): Int? {
//        return state.anchorPosition?.let { anchorPosition ->
//            state.closestItemToPosition(anchorPosition)?.page
//        }
//    }


}