package com.example.vinculacion.domain

import com.example.vinculacion.data.QuoteRepository
import com.example.vinculacion.data.model.QuoteModel

class GetQuotesUseCase {

    private val repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()




}