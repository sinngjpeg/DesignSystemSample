package br.com.dsgirls

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.TypedValue
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.core.content.ContextCompat
enum class checkBoxTypesEnum{
    PURPLE,
    BLUE,
}

class CheckBoxDesign @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatCheckBox(context, attrs, defStyleAttr) {
    private lateinit var checkBoxTypes: checkBoxTypesEnum

    init {
        setPadding(16, paddingTop, paddingEnd, paddingBottom)
        setTextSize(TypedValue.COMPLEX_UNIT_PX, 54F)
        isClickable = true
        attrs?.let {
            updateAttrs(it)
        }
    }

    private fun updateAttrs(attrs: AttributeSet) {
        val attributes: TypedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.CheckBoxDesign,
            0,
            0
        )
        val enumCheckBoxIndex = attributes.getInt(R.styleable.CheckBoxDesign_checkBoxTypes, 0)
        checkBoxTypes = checkBoxTypesEnum.values()[enumCheckBoxIndex]
        attributes.recycle()
        updateCheckBox(checkBoxTypes)
    }

    private fun updateCheckBox(status: checkBoxTypesEnum) {
        when (status) {
            checkBoxTypesEnum.BLUE -> {
                setButtonDrawable(R.drawable.checkbox_blue)
                setTextColor(ContextCompat.getColor(context, R.color.color_blue))
            }
            checkBoxTypesEnum.PURPLE -> {
                setButtonDrawable(R.drawable.checkbox_violet)
                setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.color_violet
                    )
                )
            }
        }
    }
}
