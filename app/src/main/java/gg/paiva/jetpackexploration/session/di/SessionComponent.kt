package gg.paiva.jetpackexploration.session.di

import android.content.Context
import androidx.startup.Initializer
import gg.paiva.jetpackexploration.session.SessionController
import org.koin.java.KoinJavaComponent.inject

class SessionComponent : Initializer<SessionController>{
    private val sessionController : SessionController by inject(SessionController::class.java)

    override fun create(context: Context): SessionController = sessionController

    //if need extra sub components
    override fun dependencies(): List<Class<out Initializer<*>>> = listOf(WorkManagerComponent::class.java)
}