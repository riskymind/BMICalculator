package com.asterisk.bmicalculator.ui.bmi_actions

sealed class BmiEvents {
    object OnWeightTextClick : BmiEvents()
    object OnHeightTextClick : BmiEvents()
}
