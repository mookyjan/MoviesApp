package com.mudassir.moviesapp.util

import android.os.Build
import android.text.Html
import android.text.Spanned
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.api.load
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.mudassir.moviesapp.R

@BindingAdapter("android:src")
fun loadCircleImage(imageView: ImageView, url:String?){
    url?.let {
        imageView.load(AppConstants.getPosterPath(it)){
            crossfade(true)
            placeholder(R.mipmap.ic_launcher_round)
                .transformations(CircleCropTransformation())
        }
    }
}

@BindingAdapter("loadImage")
fun loadImage(imageView: ImageView, url:String?){
    url?.let {
        imageView.load(it){
            crossfade(true)
            placeholder(R.mipmap.ic_launcher)
                .transformations(RoundedCornersTransformation())

        }
    }
}

@BindingAdapter("android:htmlText")
fun setHtmlTextValue(textView: TextView, htmlText: String?) {
    if (htmlText == null) return
    val result: Spanned
    result = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(htmlText, Html.FROM_HTML_MODE_LEGACY)
    } else {
        Html.fromHtml(htmlText)
    }
    textView.text = result
}