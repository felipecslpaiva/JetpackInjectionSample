package gg.paiva.jetpackexploration.session.workrequest

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class UploadWorker(context : Context, workerParameters: WorkerParameters) : Worker(context, workerParameters){
    override fun doWork(): Result {
        upLoadImage()
        return Result.success()
    }

    //Handle the logic here to upload the provided image for the profile picture
    private fun upLoadImage() {

    }
}