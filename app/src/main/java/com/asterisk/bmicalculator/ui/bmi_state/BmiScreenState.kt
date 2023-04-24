package com.asterisk.bmicalculator.ui.bmi_state

data class BmiScreenState(
    val bottomSheetTitle: String = "",
    val bottomSheetItems: List<String> = emptyList(),
    val weightUnit: String = "Kilograms",
    val heightUnit: String = "Centimeter",
    val weightValue: String = "60",
    val heightValue: String = "170",
    val weightValueStage: WeightValueStage = WeightValueStage.ACTIVE,
    val heightValueStage: HeightValueStage = HeightValueStage.INACTIVE,

    val bmi: Double = 0.0,
    val bmiStage: String = "",
    val shouldShowBMICard: Boolean = false,
)


enum class WeightValueStage {
    INACTIVE, ACTIVE, RUNNING
}

enum class HeightValueStage {
    INACTIVE, ACTIVE, RUNNING
}