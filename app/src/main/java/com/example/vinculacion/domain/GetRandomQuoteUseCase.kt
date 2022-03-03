package com.example.vinculacion.domain

import com.example.vinculacion.data.model.QuoteModel
import com.example.vinculacion.data.model.QuoteProvider

class GetRandomQuoteUseCase {

    operator fun invoke(): QuoteModel?{
        val quotes: List<QuoteModel> = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()){
            val randomNumber : Int = (0..quotes.size).random()
            return quotes[randomNumber]
        }
        return null
    }


}