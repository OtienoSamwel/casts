package com.otienosamwel.casts.ui.features.intro

import androidx.lifecycle.ViewModel
import com.otienosamwel.casts.utils.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class IntroViewModel @Inject constructor(preferences: Preferences) : ViewModel()