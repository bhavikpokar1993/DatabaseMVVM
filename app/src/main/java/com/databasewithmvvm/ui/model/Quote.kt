package com.databasewithmvvm.ui.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_quotes")
data class Quote(
    @PrimaryKey(autoGenerate = true)
    val mId: Int = 0, val quoteText: String,
    val author: String
) {
    override fun toString(): String {
        return "$quoteText - $author"
    }
}