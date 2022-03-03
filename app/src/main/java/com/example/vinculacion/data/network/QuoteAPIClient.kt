package com.example.vinculacion.data.network

import com.example.vinculacion.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteAPIClient {
    @GET("/.json")
    suspend fun getAllQuotes():Response<List<QuoteModel>>




}