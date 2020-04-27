package com.databasewithmvvm.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.databasewithmvvm.QuoteApplication
import com.databasewithmvvm.ui.model.Quote
import com.democake.db.dbDao.QuoteDao

@Database(
    entities = [Quote::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {


    abstract fun quoteDao(): QuoteDao

    private object Holder {
        val INSTANCE = QuoteApplication.context.applicationContext?.let {
            Room.databaseBuilder(
                it,
                AppDatabase::class.java,
                "app_database"
            ).fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
        }
    }

    companion object {
        // Tag for logcat.
        const val TAG = "ConceptDatabase"

        /**
         * Singleton instance of [ConceptDatabase]
         */
        val instance: AppDatabase? by lazy { Holder.INSTANCE }

    }
}
