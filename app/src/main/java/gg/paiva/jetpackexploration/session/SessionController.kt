package gg.paiva.jetpackexploration.session

import android.util.Log
import androidx.work.WorkManager

class SessionController(private val workManager : WorkManager) {
    init{Log.d("","Controller init" )}

    fun isSessionActive() : Boolean = true
}