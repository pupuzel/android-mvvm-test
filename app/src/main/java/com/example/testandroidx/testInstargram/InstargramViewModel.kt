package com.example.testandroidx.testInstargram

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstargramViewModel : ViewModel() {
    var following = MutableLiveData<String>()
    var counter = MutableLiveData<Int>()

    init {
        following.value = "팔로잉 0명"
        counter.value = 0
    }

    fun increase(){
        counter.value = counter.value!! +1
    }

    fun decrease(){
        counter.value = counter.value!! -1
    }
}