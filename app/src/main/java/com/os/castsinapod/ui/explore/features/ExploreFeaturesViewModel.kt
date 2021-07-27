package com.os.castsinapod.ui.explore.features

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.os.castsinapod.domain.models.PodcastsResponse
import com.os.castsinapod.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExploreFeaturesViewModel @Inject constructor(private val repository: Repository) :
    ViewModel() {
    private val _data = MutableLiveData<PodcastsResponse>()
    val data: LiveData<PodcastsResponse> get() = _data

    fun getResults(q: String) {
        viewModelScope.launch {
            _data.value = repository.getPodcasts(q)
        }
    }
}