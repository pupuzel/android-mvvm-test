package com.example.testandroidx

import android.app.Application
import com.example.testandroidx.testkoin.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        /** DI를 위한 모듈 등록 */
        startKoin{
            androidContext(applicationContext)
            modules(appModule)
        }

    }

}