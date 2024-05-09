package com.cristhian.apprecordar.domain

import com.cristhian.apprecordar.data.model.QuoteModel
import com.cristhian.apprecordar.data.repositories.QuoteRepository

class GetQuotesUseCase {
    private val repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()
}