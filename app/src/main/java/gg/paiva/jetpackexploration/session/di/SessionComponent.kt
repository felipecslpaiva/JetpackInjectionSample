package gg.paiva.jetpackexploration.session.di

import android.content.Context
import androidx.startup.Initializer
import androidx.work.WorkManager
import gg.paiva.jetpackexploration.session.SessionController

class SessionComponent : Initializer<SessionController>{
    override fun create(context: Context): SessionController =
        SessionController(WorkManager.getInstance(context))

    //if need extra sub components
    override fun dependencies(): List<Class<out Initializer<*>>> = listOf(WorkManagerComponent::class.java)
}