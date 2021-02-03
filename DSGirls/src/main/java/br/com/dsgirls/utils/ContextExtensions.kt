package br.com.dsgirls.utils

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

private const val NO_TINT = -1

fun Context.getTintedDrawable(
    @DrawableRes drawableRes: Int,
    @ColorRes tintColorRes: Int = NO_TINT
): Drawable {
    val drawable = ContextCompat.getDrawable(this, drawableRes)
    if (tintColorRes != NO_TINT) {
        drawable?.setTint(ContextCompat.getColor(this, tintColorRes))
    }
    return drawable!!
}