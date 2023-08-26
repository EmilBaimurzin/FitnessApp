package com.fitness.game.ui.other

import android.app.Application
import com.fitness.game.data.data_base.Database

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Database.init(this)
    }
}