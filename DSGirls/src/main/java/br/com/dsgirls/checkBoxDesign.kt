package br.com.dsgirls

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.TypedValue
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

class checkBoxDesign @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatCheckBox(context, attrs, defStyleAttr) {

    init {
        setPadding(16, paddingTop, paddingEnd, paddingBottom)
        setTextSize(TypedValue.COMPLEX_UNIT_PX, 24F)
        isClickable = true
        attrs?.let {
            updateAttrs(it)
        }
    }

    private fun updateAttrs(attrs: AttributeSet) {
        val attributes: TypedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.checkBox,
            0,
            0
        )
        val enumCheckBoxIndex = attributes.getInt(R.styleable.TimCheckBox_checkBoxTypes, 0)
        checkBoxTypes = TimCheckBoxTypes.values()[enumCheckBoxIndex]
        attributes.recycle()
        updateCheckBox(checkBoxTypes)
    }

    private fun updateCheckBox(statusRadio: TimCheckBoxTypes) {
        when (statusRadio) {
            TimCheckBoxTypes.ACCENT -> {
                setButtonDrawable(R.drawable.checked_accent)
                this.setTextColor(ContextCompat.getColorStateList(context, R.color.check_color))
            }
            TimCheckBoxTypes.RAISED -> {
                setButtonDrawable(R.drawable.checked_raised)
                this.setTextColor(
                    ContextCompat.getColorStateList(
                        context,
                        R.color.check_color_raised
                    )
                )
            }
        }
    }
}


}