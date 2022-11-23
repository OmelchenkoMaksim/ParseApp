package com.example.parsingapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parsingapp.data.models.ParseModel
import com.example.parsingapp.data.models.UiModel
import com.example.parsingapp.domain.repository.BaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: BaseRepository<UiModel>,
) : ViewModel() {

    private val resultLiveData = MutableLiveData<List<ParseModel>>()
    val resultLive: LiveData<List<ParseModel>> = resultLiveData

    init {
        fetch()
    }

    private fun fetch() =
        viewModelScope.launch(Dispatchers.Main) {
            val numbers = repository.fetch()
            resultLiveData.value = numbers.binary.sortedBy { parseModel ->
                parseModel.section
            }
        }
}