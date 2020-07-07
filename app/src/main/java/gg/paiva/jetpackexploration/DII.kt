package gg.paiva.jetpackexploration

import android.content.Context
import androidx.startup.Initializer
import gg.paiva.jetpackexploration.session.di.WorkManagerComponent
import gg.paiva.jetpackexploration.session.di.sessionModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class DII : Initializer<Unit>{
    override fun create(context: Context) {
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(context)
            modules(listOf(sessionModule))
        }
    }

    //This will be called even before everything soo all the components are ready
    // before it call the create method
    override fun dependencies(): List<Class<out Initializer<*>>> = listOf(WorkManagerComponent::class.java)
}