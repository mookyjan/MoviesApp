package com.mudassir.domain.usecase

import com.mudassir.domain.SchedulerProvider
import com.mudassir.domain.gateway.MovieDetailGateWay
import com.mudassir.domain.utils.TestSchedulers
import com.mudassir.domain.utils.getTestMovieDetail
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.mock
import io.reactivex.Single
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@Suppress("IllegalIdentifier")
@RunWith(MockitoJUnitRunner::class)
class GetMovieDetailUseCaseTest{

    lateinit var getMovieDetailUseCase: GetMovieDetailUseCase
    private val movieDetailGateWay: MovieDetailGateWay = mock()
    lateinit var schedulerProvider: SchedulerProvider

    @Before
    fun setUp(){
        schedulerProvider = TestSchedulers()
        getMovieDetailUseCase = GetMovieDetailUseCase(schedulerProvider,movieDetailGateWay)
    }

    @Test
    fun `get movie details when pass movie id`(){
        //Given
        val movieId =100
        val mockMovie = getTestMovieDetail(movieId)
        Mockito.`when`(movieDetailGateWay.getMovieDetail(movieId)).thenReturn(eq(Single.just(mockMovie)))
        //when
        val testObserver =getMovieDetailUseCase.execute(movieId).test()
        //then
        testObserver.assertComplete()
            .assertNoErrors()
            .assertValue(mockMovie)
    }

    @Test
    @Throws(Exception::class)
    fun `should throw exception on error`(){
        //Given
        val movieId =100
        val error = Throwable()
        Mockito.`when`(movieDetailGateWay.getMovieDetail(movieId)).thenReturn(Single.error(error))
        //when
        val result = getMovieDetailUseCase.execute(movieId).test()

        //should
        result.assertNotComplete()
            .assertError(error)
            .assertNoValues()
    }
}