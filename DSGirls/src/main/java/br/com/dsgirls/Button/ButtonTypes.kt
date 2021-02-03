package br.com.dsgirls.Button

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import br.com.dsgirls.R

enum class ButtonTypes(
    @ColorRes val mainColor: Int,
    @DrawableRes val outlinedBgDrawable: Int,
    @ColorRes val enabledTextColor: Int = R.color.color_neutral_white,
    @ColorRes val enabledOutlinedTextColor: Int
) {
    PINK(
        mainColor = R.color.color_pink,
        outlinedBgDrawable = R.drawable.rounded_border_white,
        enabledTextColor = (R.color.color_neutral_white),
        enabledOutlinedTextColor = R.color.color_pink
    ),
    PURPLE(
        mainColor = R.color.color_purple,
        outlinedBgDrawable = R.drawable.rounded_border_green,
        enabledOutlinedTextColor = R.color.color_purple
    ),
    BLUE(
        mainColor = R.color.color_primary_blue,
        outlinedBgDrawable = R.drawable.rounded_border_blue,
        enabledTextColor = R.color.color_neutral_white,
        enabledOutlinedTextColor = R.color.color_primary_blue
    ),
    RED(
        mainColor = R.color.color_secondary_red,
        outlinedBgDrawable = R.drawable.rounded_border_red,
        enabledOutlinedTextColor = R.color.color_secondary_red
    )
}