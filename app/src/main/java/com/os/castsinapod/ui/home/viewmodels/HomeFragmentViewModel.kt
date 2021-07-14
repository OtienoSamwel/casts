package com.os.castsinapod.ui.home.viewmodels

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
class HomeFragmentViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private val  _data = MutableLiveData<PodcastResponse>()
    var data : LiveData<PodcastResponse> = _data


    fun getResults(q: String) {
        viewModelScope.launch {
            _data.value = repository.getPodcasts(q)
        }
    }
}