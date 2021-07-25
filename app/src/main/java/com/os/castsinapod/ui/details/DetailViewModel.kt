package com.os.castsinapod.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.os.castsinapod.domain.models.PodcastResponse
import com.os.castsinapod.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private val _data = MutableLiveData<PodcastResponse>()
    val data: LiveData<PodcastResponse> get() = _data

    fun getPodcast(id: String) {
        viewModelScope.launch {
            _data.value = repository.getPodcast(id)
        }
    }
}