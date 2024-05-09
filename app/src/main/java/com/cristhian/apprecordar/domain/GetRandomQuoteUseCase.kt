package com.cristhian.apprecordar.domain

import com.cristhian.apprecordar.data.model.QuoteModel
import com.cristhian.apprecordar.data.model.QuoteProvider

class GetRandomQuoteUseCase {
    operator fun invoke():QuoteModel?{
        val quotes:List<QuoteModel> = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}