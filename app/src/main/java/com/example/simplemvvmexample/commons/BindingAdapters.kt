package com.example.simplemvvmexample.commons

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.databinding.BindingAdapter
import com.example.simplemvvmexample.R
import com.example.simplemvvmexample.viewmodel.FragmentInteractionVM
import com.example.simplemvvmexample.viewmodel.Popularity

@BindingAdapter("bindPopularInage")
fun bindPopularImage(imageView: ImageView, popularity: Popularity?) {
    val color = getAssociatedColor(popularity, imageView.context)
    ImageViewCompat.setImageTintList(imageView, ColorStateList.valueOf(color))
    imageView.setImageDrawable(getPopularityImageDrawable(popularity, imageView.context))
}

fun getPopularityImageDrawable(popularity: Popularity?, context: Context) : Drawable? {
    popularity?.let {
        return when (popularity) {
            Popularity.NORMAL -> {
                ContextCompat.getDrawable(context, R.drawable.ic_person)
            }
            Popularity.POPULAR, Popularity.STAR -> {
                ContextCompat.getDrawable(context, R.drawable.ic_fire)
            }
        }
    } ?: return ContextCompat.getDrawable(context, R.drawable.ic_person)

}


private fun getAssociatedColor(popularity: Popularity?, context: Context): Int {
    popularity?.let {
        return when (popularity) {
            Popularity.NORMAL -> context.theme.obtainStyledAttributes(
                intArrayOf(android.R.attr.colorForeground)
            ).getColor(0, 0x000000)
            Popularity.POPULAR -> ContextCompat.getColor(context, R.color.popular)
            Popularity.STAR -> ContextCompat.getColor(context, R.color.star)
        }
    } ?: return ContextCompat.getColor(context, R.color.black)
}