package com.example.vinculacion.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.vinculacion.databinding.ActivityMainBinding
import com.example.vinculacion.ui.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, Observer{
            binding.tvQuote.text = it.quote
            binding.tvAuthor.text = it.author
        })

        quoteViewModel.isLoading.observe(this, Observer{
            binding.progress.isVisible = it
        })

        quoteViewModel.message.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })


        binding.inteligente.setOnClickListener {
            quoteViewModel.randomQuote()
        }



    }
}