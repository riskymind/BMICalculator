package com.asterisk.bmicalculator.ui.bmi_actions

import android.content.Context

sealed class BmiEvents {
    object OnWeightTextClick : BmiEvents()
    object OnHeightTextClick : BmiEvents()
    object OnWeightValueClick : BmiEvents()
    object OnHeightValueClick : BmiEvents()
    object AllClearButtonClick : BmiEvents()
    object BackSpaceClick : BmiEvents()
    data class OnGoClick(val context: Context) : BmiEvents()
    data class BottomSheetItemSelected(val item: String) : BmiEvents()
    data class OnNumberClick(val number: String) : BmiEvents()
}
