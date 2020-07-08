package gg.paiva.jetpackexploration.session.di.koin

import androidx.work.WorkManager
import gg.paiva.jetpackexploration.session.SessionController
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val sessionControllerModule = module {
    single<SessionController> {
        SessionController(
            WorkManager.getInstance(
                androidContext()
            )
        )
    }
}