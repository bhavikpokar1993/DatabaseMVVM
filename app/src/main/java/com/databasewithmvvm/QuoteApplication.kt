package com.databasewithmvvm

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.pm.ActivityInfo
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate


/**
 * [QuoteApplication] :
 *
 * @author : Nirav Joshi
 * @version 1.0.0
 * @since 10/15/2019
 */
class QuoteApplication : Application() {
    companion object {
        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        }

        @Volatile
        @JvmStatic
        lateinit var context: QuoteApplication

        @JvmStatic
        fun isNetworkConnected(): Boolean {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
            val activeNetwork = connectivityManager?.activeNetworkInfo
            return activeNetwork != null && activeNetwork.isConnected
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }


}