package com.os.casts.ui.features.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.otienosamwel.data.models.PodcastsResponse
import com.otienosamwel.data.repositories.podcastRepository.PodcastRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: PodcastRepository) : ViewModel() {

    private var _podcasts: MutableLiveData<PodcastsResponse> = MutableLiveData<PodcastsResponse>()
    val podcasts: LiveData<PodcastsResponse> get() = _podcasts

    private fun getPodcasts() {
        viewModelScope.launch {
            _podcasts.value = repository.getPodcasts("harry")
        }
    }

    init {
        getPodcasts()
    }
}