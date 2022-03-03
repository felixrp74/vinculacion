package com.example.vinculacion.ui.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vinculacion.data.model.QuoteModel
import com.example.vinculacion.data.model.QuoteProvider
import com.example.vinculacion.domain.GetQuotesUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()
    val message = MutableLiveData<String>()

    var getQuotesUseCase = GetQuotesUseCase()

    fun onCreate() {
        isLoading.postValue(true)
        viewModelScope.launch {
            val result = getQuotesUseCase()

            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result[1])
                isLoading.postValue(false)
            } else {
                message.postValue("no responde link")
            }

        }

    }

    fun randomQuote() {
        /*val currentQuote = QuoteProvider.random()
        quoteModel.postValue(currentQuote)*/
        val index = rand (0..11)

    }


}