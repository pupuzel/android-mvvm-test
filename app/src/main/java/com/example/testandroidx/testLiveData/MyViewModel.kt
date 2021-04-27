package com.example.testandroidx.testLiveData

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MyViewModel : ViewModel() {
    private val user: MutableLiveData<String> by lazy {
        MutableLiveData<String>("테스트")
    }

    fun setUsers(str: String) {
        user.value = str
    }

    fun getUsers(): LiveData<String> {
        return user
    }

}