package com.example.vinculacion.data.network

import com.example.vinculacion.core.RetrofitHelper
import com.example.vinculacion.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.create

class QuoteService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes():List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(QuoteAPIClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }

    }


}