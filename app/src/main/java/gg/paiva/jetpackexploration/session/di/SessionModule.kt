package gg.paiva.jetpackexploration.session.di

import androidx.work.WorkManager
import gg.paiva.jetpackexploration.session.SessionController
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val sessionModule = module {
    single<SessionController> {
        SessionController(
            WorkManager.getInstance(
                androidContext()
            )
        )
    }
}