package com.cristhian.apprecordar.data.network.services

import com.cristhian.apprecordar.data.model.QuoteModel
import com.cristhian.apprecordar.data.network.clients.QuoteApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class QuoteService @Inject constructor(
    private val api:QuoteApiClient
) {
    suspend fun getQuotes():List<QuoteModel>{
        return withContext(Dispatchers.IO){
            //val response:Response<List<QuoteModel>> = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            val response:Response<List<QuoteModel>> = api.getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}