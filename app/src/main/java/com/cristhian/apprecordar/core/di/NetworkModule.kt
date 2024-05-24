package com.cristhian.apprecordar.core.di

import com.cristhian.apprecordar.core.RetrofitHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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
}