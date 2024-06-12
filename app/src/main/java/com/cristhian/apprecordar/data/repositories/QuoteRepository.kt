package com.cristhian.apprecordar.data.repositories

import com.cristhian.apprecordar.data.model.QuoteModel
import com.cristhian.apprecordar.data.model.QuoteProvider
import com.cristhian.apprecordar.data.network.services.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api:QuoteService,
    private val quoteProvider:QuoteProvider
) {
    suspend fun getAllQuotes():List<QuoteModel>{
        val response:List<QuoteModel> = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}