package com.os.casts.ui.explore.features

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
class ExploreFeaturesViewModel @Inject constructor(private val repository: PodcastRepository) :
    ViewModel() {
    private val _data = MutableLiveData<PodcastsResponse>()
    val data: LiveData<PodcastsResponse> get() = _data

    fun getResults(q: String) {
        viewModelScope.launch {
            _data.value = repository.getPodcasts(q)
        }
    }
}