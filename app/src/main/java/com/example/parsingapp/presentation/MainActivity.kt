package com.example.parsingapp.presentation

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.parsingapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewModel by viewModel<MainViewModel>()
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerView = findViewById(R.id.recyclerView)
        viewModel.resultLive.observe(this) { list ->
            recyclerView.adapter = Adapter(list)
            if (list.isEmpty()) {
                findViewById<TextView>(R.id.warning).visibility = View.VISIBLE
            }
        }
    }
}