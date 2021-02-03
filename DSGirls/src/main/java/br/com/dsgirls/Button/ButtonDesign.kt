package br.com.dsgirls

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.StateListDrawable
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import br.com.dsgirls.Button.ButtonTypes
import br.com.dsgirls.utils.ViewStates.disabledState
import br.com.dsgirls.utils.ViewStates.enabledDisabledStates
import br.com.dsgirls.utils.ViewStates.enabledState
import br.com.dsgirls.utils.getTintedDrawable


class ButtonDesign @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    var label: String? = null
        set(value) {
            if (field != value) {
                applyButtonStyle()
                field = value
            }
        }


    private lateinit var buttonType: ButtonTypes
    private var isOutlined = false
    private var iconResId = -1

    private val backgroundView by lazy { findViewById<View>(R.id.background) }
    private val textView by lazy { findViewById<TextView>(R.id.text) }
    private val iconView by lazy { findViewById<ImageView>(R.id.icon) }


    init {
        inflate(context, R.layout.girls_button, this)

        setUpButton(attrs)
    }

    private fun setUpButton(attrs: AttributeSet?) {
        with(context.obtainStyledAttributes(attrs, R.styleable.ButtonDesign, 0, 0)) {
            val enumButtonTypeIndex = getInt(R.styleable.ButtonDesign_buttonTypes, 0)
            buttonType = ButtonTypes.values()[enumButtonTypeIndex]
            isOutlined = getBoolean(R.styleable.ButtonDesign_isOutlined, false)
            iconResId = getResourceId(R.styleable.ButtonDesign_icon, -1)
            label = getString(R.styleable.ButtonDesign_label)
            recycle()
        }

        applyButtonStyle()
    }

    private fun applyButtonStyle() {
        applyBackgroundStyle()
        applyForegroundStyle()
        applyIconStyle()
    }

    private fun applyBackgroundStyle() {
        val emptySelector = StateListDrawable()

        val background = if (isOutlined) {
            val borderDrawable = context.getTintedDrawable(buttonType.outlinedBgDrawable)
            val borderDrawableDisabled =
                context.getTintedDrawable(R.drawable.rounded_border_disabled)

            emptySelector.apply {
                addState(enabledState, borderDrawable)
                addState(disabledState, borderDrawableDisabled)
            }
        } else {
            val filledDrawable =
                context.getTintedDrawable(R.drawable.rounded_corners_blue, buttonType.mainColor)
            val filledDrawableDisabled =
                context.getTintedDrawable(R.drawable.rounded_corners_disabled)

            emptySelector.apply {
                addState(enabledState, filledDrawable)
                addState(disabledState, filledDrawableDisabled)
            }
        }

        backgroundView.background = background
    }

    private fun applyForegroundStyle() {
        val gray = ContextCompat.getColor(context, R.color.color_neutral_grey)
        val white = ContextCompat.getColor(context, R.color.color_neutral_white)

        val textColor = if (isOutlined) {
            val outlinedTextColor =
                ContextCompat.getColor(context, buttonType.enabledOutlinedTextColor)
            ColorStateList(enabledDisabledStates, intArrayOf(outlinedTextColor, gray))
        } else {
            val textColor = ContextCompat.getColor(context, buttonType.enabledTextColor)
            ColorStateList(enabledDisabledStates, intArrayOf(textColor, white))
        }

        textView.setTextColor(textColor)
        textView.text = label

        iconView.imageTintList = textColor
    }

    private fun applyIconStyle() {
        iconView.visibility = if (iconResId != -1) {
            View.VISIBLE
        } else {
            View.GONE
        }

        if (iconResId != -1) {
            iconView.setImageResource(iconResId)
        }
    }
}


