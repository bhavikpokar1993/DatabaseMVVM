package com.democake.db.dbDao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.databasewithmvvm.ui.model.Quote
import io.reactivex.Observable


@Dao
interface QuoteDao : BaseDao<Quote> {

    // LiveData is a data holder class that can be observed within a given lifecycle.
    // Always holds/caches latest version of data. Notifies its active observers when the
    // data has changed. Since we are getting all the contents of the database,
    // we are notified whenever any of the database contents have changed.
    @Query("SELECT * from tbl_quotes")
    fun getQuotes(): LiveData<List<Quote>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addQuote(addToCartCake: Quote)



}

