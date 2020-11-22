package com.mudassir.moviesapp.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mudassir.domain.usecase.GetMovieDetailUseCase
import com.mudassir.moviesapp.utils.TestData
import io.reactivex.Single
import org.hamcrest.core.Is
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieDetailViewModelTest {

    @Mock
    lateinit var getMovieDetailUseCase: GetMovieDetailUseCase
    lateinit var movieDetailViewModel: MovieDetailViewModel
    val movieId = 100

    //to update the value of mutableLive data instantly
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        movieDetailViewModel = MovieDetailViewModel(getMovieDetailUseCase)
    }

    @Test
    fun `Given movie detail, when call the api ,should update the movie detail object `() {

        //given
        val domainData = TestData.getTestMovieDetail(movieId)

        Mockito.`when`(getMovieDetailUseCase.execute(movieId)).thenReturn(Single.just(domainData))

        //when
        movieDetailViewModel.getMovieDetail(movieId)

        //to check the one value for testing
        val expectedValue = 100
        assertNotNull(movieDetailViewModel.movieDetail)

        assertEquals(expectedValue, movieDetailViewModel.movieDetail.value?.id)
    }

    @Test
    @Throws(Exception::class)
    fun `Given error emission, when load repo list with error, should update error`() {

        //Given
        val error = RuntimeException("Unknown error")

        Mockito.`when`(getMovieDetailUseCase.execute(movieId)).thenReturn(Single.error(error))

        //when
        movieDetailViewModel.getMovieDetail(movieId)

        //should
        assertThat(movieDetailViewModel.error.value, Is.`is`(error.message))
    }

}