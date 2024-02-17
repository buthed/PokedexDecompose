package com.core.network

import com.core.network.utils.RetrofitConstants
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiServiseTest {

    lateinit var mockWebServer: MockWebServer
    lateinit var apiService: ApiService

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        apiService = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(RetrofitConstants.BASE_URL)
            .build()
            .create(ApiService::class.java)
    }

    @Test
    fun testGetPokemonsList() = runBlocking {
        val mockResponse = MockResponse()
        mockResponse.setBody("[]")
        mockWebServer.enqueue(mockResponse)

        val response = apiService.getPokemonsList(limit = 1010, offset = 0)
        mockWebServer
            .takeRequest(2000L, TimeUnit.MILLISECONDS)

        Assert.assertEquals(true, response.results.isNotEmpty())
    }

    @Test
    fun testGetPokemonDetails() = runBlocking {
        val mockResponse = MockResponse()
        mockResponse.setBody("[]")
        mockWebServer.enqueue(mockResponse)

        val response = apiService.getPokemonDetails("bulbasaur")
        mockWebServer
            .takeRequest(2000L, TimeUnit.MILLISECONDS)

        Assert.assertEquals(1, response.id)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}