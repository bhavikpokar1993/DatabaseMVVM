package com.databasewithmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.databasewithmvvm.ui.viewModel.QuotesViewModel
import com.resocoder.mvvmbasicstut.utilities.InjectorUtils
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.databasewithmvvm.ui.model.Quote
import kotlinx.android.synthetic.main.activity_qoute.*

class QoutesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qoute)

        initializeUi()
    }

    private fun initializeUi() {
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text = stringBuilder.toString()
        })

        button_add_quote.setOnClickListener {
            val quote = Quote(
                quoteText = editText_quote.text.toString(),
                author = editText_author.text.toString()
            )
            viewModel.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
    }
}
