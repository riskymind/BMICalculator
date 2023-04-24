package com.asterisk.bmicalculator.ui.bmi

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asterisk.bmicalculator.components.*
import com.asterisk.bmicalculator.ui.bmi_state.BmiScreenState
import com.asterisk.bmicalculator.ui.bmi_state.HeightValueStage
import com.asterisk.bmicalculator.ui.bmi_state.WeightValueStage
import com.asterisk.bmicalculator.ui.theme.*

@Composable
fun BMIScreenContent(
    state: BmiScreenState,
    onWeightUnitClick: () -> Unit,
    onHeightUnitClick: () -> Unit,
    onWeightValueClick: () -> Unit,
    onHeightValueClick: () -> Unit,
    onNumberClick: (String) -> Unit,
    onAllClearClick: () -> Unit,
    onBackSpaceClick: () -> Unit,
    onGoClick: () -> Unit,
    onShareClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GrayBackground)
            .padding(15.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "BMI Calculator",
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(40.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                UnitItem(unitType = "Weight", onUnitClick = onWeightUnitClick)
                InputUnitValue(unitValue = state.weightValue,
                    unit = state.weightUnit,
                    inputColor = if (state.weightValueStage != WeightValueStage.INACTIVE) {
                        CustomOrange
                    } else {
                        Color.Black
                    },
                    onUnitValueClick = onWeightValueClick
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                UnitItem(unitType = "Height", onUnitClick = onHeightUnitClick)
                InputUnitValue(unitValue = state.heightValue,
                    unit = state.heightUnit,
                    inputColor = if (state.heightValueStage != HeightValueStage.INACTIVE) {
                        CustomOrange
                    } else {
                        Color.Black
                    },
                    onUnitValueClick = onHeightValueClick
                )
            }
        }

        Crossfade(targetState = state.shouldShowBMICard) {
            if (it) {
                Column(
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    BmiResult(
                        bmi = state.bmi,
                        bmiState = state.bmiStage,
                        bmiStateColor = when (state.bmiStage) {
                            "Underweight" -> CustomBlue
                            "Overweight" -> CustomRed
                            else -> CustomGreen
                        }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    ShareButton(modifier = Modifier.fillMaxWidth(), onClick = onShareClick)
                }
            } else {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)) {
                    Divider()
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        NumberKeyboard(
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(7f),
                            onNumberClick = { onNumberClick(it) }
                        )
                        Column(modifier = Modifier
                            .fillMaxHeight()
                            .weight(3f),
                            verticalArrangement = Arrangement.SpaceBetween) {
                            SymbolButton(symbol = "AC", onSymbolClick = onAllClearClick)
                            SymbolButtonWithIcon(onSymbolClick = onBackSpaceClick)
                            SymbolButton(symbol = "GO", onSymbolClick = onGoClick)
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BMIScreenContentPreview() {
    BMICalculatorTheme {
        BMIScreenContent(
            state = BmiScreenState(),
            onWeightUnitClick = {},
            onHeightUnitClick = {},
            onWeightValueClick = {},
            onHeightValueClick = {},
            onNumberClick = {},
            onAllClearClick = {},
            onBackSpaceClick = {},
            onGoClick = {},
            onShareClick = {}
        )
    }
}