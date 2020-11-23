package com.mudassir.moviesapp.util

import android.os.Build
import android.text.Html
import android.text.Spanned
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import coil.api.load
import com.bumptech.glide.Glide
import com.github.florent37.glidepalette.BitmapPalette
import com.github.florent37.glidepalette.GlidePalette
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.mudassir.moviesapp.R
import com.mudassir.moviesapp.ui.detail.GenreModel


@BindingAdapter("android:src", "palette")
fun bindingImage(imageView: ImageView, path: String?, palette: View?) {

    path?.let {
        Glide.with(imageView.context)
            .load(AppConstants.getPosterPath(it))
            .error(ContextCompat.getDrawable(imageView.context, R.drawable.loading))
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
        imageView.load(AppConstants.getPosterPath(it)) {
            placeholder(R.drawable.loading)
        }
    }
}

/**
 * binding for the rating bar, and divide it by 2 t
 */


@BindingAdapter("android:rating")
fun setRating(view: RatingBar?, rating: Double) {

    if (view != null) {
        val rate = rating.toFloat()
        view.rating = rate/2
    }
}


@BindingAdapter("time")
fun calculateTime(view:TextView,time: Int){
 val hours = time/60
    val min = time % 60
    view.text = "$hours h: $min m"
}

@BindingAdapter("mapGenersList")
fun bindMapKeywordList(chipGroup: ChipGroup, geners: List<GenreModel>?) {
    geners?.let {
        chipGroup.visible()
        for (keyword in it) {
            val chip = Chip(chipGroup.context)
            chip.text = keyword.name
            chip.isCheckable = false
            chip.setTextAppearanceResource(R.style.ChipTextStyle)
            chip.setChipBackgroundColorResource(R.color.colorPrimary)
            chipGroup.addView(chip)
        }
    }
}


/** makes visible a view. */
fun View.visible() {
    visibility = View.VISIBLE
}

/** makes gone a view. */
fun View.gone() {
    visibility = View.GONE
}