package gg.paiva.jetpackexploration.session.di.jetpack

import android.content.Context
import androidx.startup.Initializer
import androidx.work.Configuration
import androidx.work.WorkManager

class WorkManagerComponent : Initializer<WorkManager>{
    override fun create(context: Context): WorkManager {
        val configuration = Configuration.Builder()
            .setMinimumLoggingLevel(android.util.Log.INFO)
            .build()
        WorkManager.initialize(context, configuration)
        return WorkManager.getInstance(context)
    }

    //if need extra sub components
    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}