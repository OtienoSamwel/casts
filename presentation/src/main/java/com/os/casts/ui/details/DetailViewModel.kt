package com.os.casts.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.otienosamwel.data.models.SinglePodcastResponse
import com.otienosamwel.data.repositories.podcastRepository.PodcastRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: PodcastRepository) : ViewModel() {
    private val _data = MutableLiveData<SinglePodcastResponse>()
    val data: LiveData<SinglePodcastResponse> get() = _data

    fun getPodcast(id: String) {
        viewModelScope.launch {
            _data.value = repository.getPodcast(id)
        }
    }
}