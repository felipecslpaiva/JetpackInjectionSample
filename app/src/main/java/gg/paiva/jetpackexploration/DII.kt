package gg.paiva.jetpackexploration

import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import gg.paiva.jetpackexploration.session.di.SessionComponent

class DII : Initializer<Unit>{

    override fun create(context: Context) {
        Log.d("" ,"")
    }

    //This will be called even before everything soo all the components are ready
    // before it call the create method
    override fun dependencies(): List<Class<out Initializer<*>>> = listOf(SessionComponent::class.java)
}