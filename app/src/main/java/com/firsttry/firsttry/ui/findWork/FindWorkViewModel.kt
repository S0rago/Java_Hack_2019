package com.firsttry.firsttry.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FindWorkViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is find work Fragment"
    }
    val text: LiveData<String> = _text
}