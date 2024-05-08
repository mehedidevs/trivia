package com.mehedi.trivia

import android.app.Application
import timber.log.Timber
import timber.log.Timber.Forest.plant


class TriviaApp : Application() {

    override fun onCreate() {
        super.onCreate()

        plant(Timber.DebugTree())

    }

}