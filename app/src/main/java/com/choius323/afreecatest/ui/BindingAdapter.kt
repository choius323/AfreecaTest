package com.choius323.afreecatest.ui

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

@BindingAdapter("loadImageByUri")
fun loadImageByUri(imageView: ImageView, inputUri: String?) {
    val uri = inputUri?.dropWhile { it == '/' }?.let { uri ->
        if (uri.startsWith("https://")) {
            uri
        } else {
            "https://$uri"
        }
    } ?: return
    Log.d("setImage", "setImage: $uri")
    Glide.with(imageView.context)
        .load(uri)
        .fitCenter()
        .placeholder(android.R.drawable.ic_popup_sync)
        .error(android.R.drawable.sym_def_app_icon)
        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
        .into(imageView)
}