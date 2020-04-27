package com.databasewithmvvm.ui.viewModel

import androidx.lifecycle.ViewModel
import com.databasewithmvvm.ui.model.Quote

class QuotesViewModel(private val quoteRepository: QuoteRepository)
    : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}