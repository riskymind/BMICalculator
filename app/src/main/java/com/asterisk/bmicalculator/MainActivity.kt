package com.asterisk.bmicalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.asterisk.bmicalculator.ui.bmi.BmiScreen
import com.asterisk.bmicalculator.ui.bmi_viewmodel.BmiScreenViewModel
import com.asterisk.bmicalculator.ui.theme.BMICalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMICalculatorTheme {
                val viewModel by viewModels<BmiScreenViewModel>()
                BmiScreen(
                    viewModel.state,
                ) {
                    viewModel.onEvent(it)
                }
            }
        }
    }
}

