package com.example.parsingapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parsingapp.data.models.ListBinariesForUI
import com.example.parsingapp.data.models.ParseModel
import com.example.parsingapp.domain.repository.BaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val repository: BaseRepository<ListBinariesForUI>,
) : ViewModel(), VM {

    private val resultLiveData = MutableLiveData<List<ParseModel>>()
    val resultLive: LiveData<List<ParseModel>> = resultLiveData

    init {
        fetch()
    }

    override fun fetch() {
        viewModelScope.launch(Dispatchers.IO) {
            val numbers = repository.fetch()
            withContext(Dispatchers.Main) {
                resultLiveData.value = numbers.binaries.sortedBy { parseModel ->
                    parseModel.section
                }
            }
        }
    }
}

interface VM {
    fun fetch()
}