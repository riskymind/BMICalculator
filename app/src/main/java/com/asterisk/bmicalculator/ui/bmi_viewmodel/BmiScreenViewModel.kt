package com.asterisk.bmicalculator.ui.bmi_viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.asterisk.bmicalculator.ui.bmi_actions.BmiEvents
import com.asterisk.bmicalculator.ui.bmi_state.BmiScreenState

class BmiScreenViewModel : ViewModel() {


    var state by mutableStateOf(BmiScreenState())
        private set


    fun onEvent(events: BmiEvents) {
        when (events) {
            BmiEvents.OnHeightTextClick -> {
                state = state.copy(
                    bottomSheetTitle = "Height",
                    bottomSheetItems = listOf("Centimeter", "Meter", "Feet", "Inches")
                )
            }
            BmiEvents.OnWeightTextClick -> {
                state = state.copy(
                    bottomSheetTitle = "Weight",
                    bottomSheetItems = listOf("Kilograms", "Pounds")
                )
            }
        }
    }

}