package com.example.usecasesapp.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.usecasesapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    // LazyThreadSafetyMode.NONE - это отключение синхронизации т.к. многопоточка не требуется, а по дефолту лейзи синхронизирован
    private val viewModel: MainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<EditText>(R.id.dataEditView)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        viewModel.resultLive.observe(this) { text ->
            dataTextView.text = text
        }

        sendButton.setOnClickListener {
            val text = dataEditView.text.toString()
            viewModel.save(text)
        }

        receiveButton.setOnClickListener {
            viewModel.load()
        }
    }

}