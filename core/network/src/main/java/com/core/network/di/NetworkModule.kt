package com.core.network.di


import com.core.network.ApiService
import com.core.network.dataproviders.PokedexDataProvider
import com.core.network.utils.RetrofitConstants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): ApiService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    fun providePokedexDataProvider(apiService: ApiService): PokedexDataProvider {
        return PokedexDataProvider(apiService)
    }
}