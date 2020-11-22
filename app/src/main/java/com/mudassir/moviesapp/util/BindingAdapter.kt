package com.mudassir.moviesapp.util

import android.os.Build
import android.text.Html
import android.text.Spanned
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import coil.api.load
import coil.transform.RoundedCornersTransformation
import com.bumptech.glide.Glide
import com.github.florent37.glidepalette.BitmapPalette
import com.github.florent37.glidepalette.GlidePalette
import com.mudassir.moviesapp.R

@BindingAdapter("android:src", "palette")
fun bindingImage(imageView: ImageView, path: String?, palette: View?) {

    path?.let {
        Glide.with(imageView.context)
            .load(AppConstants.getPosterPath(it))
            .error(ContextCompat.getDrawable(imageView.context, R.mipmap.ic_launcher))
            .listener(
                palette?.let {
                    GlidePalette.with(AppConstants.getPosterPath(path))
                        .use(BitmapPalette.Profile.VIBRANT)
                        .intoBackground(it)
                        .crossfade(true)
                }
            )
            .into(imageView)
    }
}

@BindingAdapter("loadImage")
fun loadImage(imageView: ImageView, url: String?) {
    url?.let {
        imageView.load(it) {
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