package com.mudassir.data.mapper

import com.mudassir.data.utils.TestData
import com.nhaarman.mockito_kotlin.eq
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MovieDetailMapperTest {

    @Test
    fun `data model with full data maps to MovieDetailDomainModel`() {
        //given
        val dataResponse = TestData.getMovieDetailResponse()
        val domainModel = TestData.getTestMovieDetail(100)
        //when
        val result = MovieDetailToDomainMapper.transformFrom(dataResponse)

        //Then
        assertEquals(result, domainModel)
        assertEquals(eq(result), eq(domainModel))
    }

    //TODO same like for other classes


}