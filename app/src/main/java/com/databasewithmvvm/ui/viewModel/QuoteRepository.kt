package com.databasewithmvvm.ui.viewModel

import com.databasewithmvvm.ui.model.Quote
import com.democake.db.dbDao.QuoteDao


class QuoteRepository private constructor(private val quoteDao: QuoteDao){

    fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    fun getQuotes() = quoteDao.getQuotes()

    companion object {
        @Volatile private var instance: QuoteRepository? = null

        fun getInstance(quoteDao: QuoteDao) =
                instance ?: synchronized(this) {
                    instance ?: QuoteRepository(quoteDao).also { instance = it }
                }
    }
}