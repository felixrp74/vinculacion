package com.example.vinculacion.data

import com.example.vinculacion.data.model.QuoteModel
import com.example.vinculacion.data.model.QuoteProvider
import com.example.vinculacion.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }


}