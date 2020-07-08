package gg.paiva.jetpackexploration.base

import android.content.Context
import androidx.startup.Initializer
import gg.paiva.jetpackexploration.session.di.jetpack.WorkManagerComponent
import gg.paiva.jetpackexploration.session.di.koin.sessionControllerModule
import gg.paiva.jetpackexploration.weather.di.secondFragmentModule
import gg.paiva.jetpackexploration.weather.di.weatherRepositoryModule
import gg.paiva.jetpackexploration.weather.di.weatherViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class DII : Initializer<Unit>{
    override fun create(context: Context) {
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(context)
            modules(listOf(
                networkModule, // All base retrofit stuff is here
                weatherRepositoryModule, //Our Weather repository
                weatherViewModelModule, //Our Weather view model
                secondFragmentModule, // Our Fragment model
                sessionControllerModule //Our session controller
            ))
        }
    }

    //This will be called even before everything soo all the components are ready
    // before it call the create method
    override fun dependencies(): List<Class<out Initializer<*>>> = listOf(WorkManagerComponent::class.java)
}