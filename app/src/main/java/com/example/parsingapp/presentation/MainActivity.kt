package com.example.parsingapp.presentation

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.parsingapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewModel by viewModel<MainViewModel>()

    // LazyThreadSafetyMode.NONE - this parameter disables synchronisation for best performance
    private val recyclerView: RecyclerView by lazy(LazyThreadSafetyMode.NONE) { findViewById(R.id.recyclerView) }
    private val connectionWarningMessage: TextView by lazy(LazyThreadSafetyMode.NONE) { findViewById(R.id.connectionWarningMessage) }
    private val repeatRequestButton: ImageButton by lazy(LazyThreadSafetyMode.NONE) { findViewById(R.id.repeatRequestButton) }
    private val parseAdapter by lazy(LazyThreadSafetyMode.NONE) { Adapter(listOf()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.resultLive.observe(this) { uiModels ->
            parseAdapter.updateList(uiModels)
            recyclerView.adapter = parseAdapter
            connectionWarningMessage.isVisible = uiModels.isEmpty()
        }
        repeatRequestButton.setOnClickListener {
            viewModel.fetch()
        }

    }
}