package com.example.testandroidx.testkoin

import android.util.Log

class StudentController(val service: SchoolService) {

    fun print(){
        Log.d("족","${service.testName}")
    }
}