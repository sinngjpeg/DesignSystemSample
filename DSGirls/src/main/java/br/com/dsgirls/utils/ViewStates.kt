package br.com.dsgirls.utils

object ViewStates {
    val enabledState = intArrayOf(android.R.attr.state_enabled)
    val disabledState = intArrayOf(-android.R.attr.state_enabled)
    val enabledDisabledStates = arrayOf(enabledState, disabledState)
}