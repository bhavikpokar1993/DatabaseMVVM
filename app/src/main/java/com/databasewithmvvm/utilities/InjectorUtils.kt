package com.resocoder.mvvmbasicstut.utilities

import com.databasewithmvvm.db.AppDatabase
import com.databasewithmvvm.ui.viewModel.QuoteRepository
import com.databasewithmvvm.ui.viewModel.QuotesViewModelFactory


object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quoteRepository = AppDatabase.instance?.quoteDao()?.let { QuoteRepository.getInstance(it) }
        return quoteRepository?.let { QuotesViewModelFactory(it) }!!
    }
}