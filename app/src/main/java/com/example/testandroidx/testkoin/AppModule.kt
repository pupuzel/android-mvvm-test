package com.example.testandroidx.testkoin

import org.koin.dsl.module

val appModule = module {
    single { SchoolService() }
    single { StudentController(get()) }
}