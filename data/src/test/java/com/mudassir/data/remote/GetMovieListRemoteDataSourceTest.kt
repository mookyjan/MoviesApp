package com.mudassir.data.remote

import com.mudassir.data.NetworkModule
import com.mudassir.data.remote.api.MovieService
import com.mudassir.data.utils.TestData
import io.reactivex.Single
import okhttp3.OkHttpClient
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetMovieListRemoteDataSourceTest{

    @Mock
    private lateinit var movieService: MovieService
    private lateinit var remoteDataSource: GetMovieListRemoteDataSource
    val movieId =100

    @Before
    fun setup(){
        remoteDataSource = GetMovieListRemoteDataSource(movieService)
    }

    @Test
    fun `get movie detail from api and check the id value that it matches the reponse value`(){
        //Given
        val result = Single.just(TestData.getMovieDetailResponse())
        //when
        Mockito.`when`(remoteDataSource.getMovieDetail(movieId)).thenReturn(result)

        val response = movieService.getMovieDetails(movieId)
        //should
         assertNotNull(response)
         assertEquals(result.blockingGet(),response.blockingGet())
       //also check the size of the list will be 1
        assertEquals(100,response.blockingGet().id)
    }


}