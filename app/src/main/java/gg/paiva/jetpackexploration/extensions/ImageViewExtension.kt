package gg.paiva.jetpackexploration.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadUrl(url : String, targetView : ImageView){
    Glide
        .with(this.context)
        .load(url)
        .centerCrop()
        .into(targetView)
}