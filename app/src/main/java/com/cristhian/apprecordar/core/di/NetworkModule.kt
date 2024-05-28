package com.cristhian.apprecordar.core.di

import com.cristhian.apprecordar.core.RetrofitHelper
import com.cristhian.apprecordar.data.network.clients.QuoteApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // Singleton persiste durante toda la vida de la app
object NetworkModule {
    private const val BASE_URL = "https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/"
    // Proveer Retrofit
    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        // val BASE_URL = "https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/"
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideQuoteApiClient(retrofit: Retrofit): QuoteApiClient {
        return retrofit.create(QuoteApiClient::class.java)
    }
}