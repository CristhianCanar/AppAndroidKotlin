package com.cristhian.apprecordar.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cristhian.apprecordar.data.model.QuoteModel
import com.cristhian.apprecordar.data.model.QuoteProvider
import com.cristhian.apprecordar.domain.GetQuotesUseCase
import com.cristhian.apprecordar.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel:ViewModel() {
    val quoteModel = MutableLiveData<QuoteModel?>()
    // Para mostrar el loading de carga
    val isLoading = MutableLiveData<Boolean>()

    // Use cases
    var getQuotesUseCase = GetQuotesUseCase()
    var getRandomQuoteUseCase = GetRandomQuoteUseCase()
    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result:List<QuoteModel>? = getQuotesUseCase()

            if (!result.isNullOrEmpty()){
                isLoading.postValue(false)
                quoteModel.postValue(result[0])
            }
        }
    }

    fun randomQuote(){
        isLoading.postValue(true)
        val quote = getRandomQuoteUseCase()
        if (quote != null){
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)
    }



}