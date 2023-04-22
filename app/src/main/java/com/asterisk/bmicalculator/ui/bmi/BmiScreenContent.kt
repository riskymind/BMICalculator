package com.asterisk.bmicalculator.ui.bmi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asterisk.bmicalculator.components.*
import com.asterisk.bmicalculator.ui.theme.BMICalculatorTheme
import com.asterisk.bmicalculator.ui.theme.GrayBackground

@Composable
fun BMIScreenContent(
    onWeightUnitClick: () -> Unit,
    onHeightUnitClick: () -> Unit,
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
                InputUnitValue(unitValue = "60", unit = "Kilogram", onUnitValueClick = {})
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
                InputUnitValue(unitValue = "170", unit = "Kilogram", onUnitValueClick = {})
            }
        }

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
                    onNumberClick = {}
                )
                Column(modifier = Modifier
                    .fillMaxHeight()
                    .weight(3f),
                    verticalArrangement = Arrangement.SpaceBetween) {
                    SymbolButton(symbol = "AC", onSymbolClick = {})
                    SymbolButtonWithIcon(onSymbolClick = {})
                    SymbolButton(symbol = "GO", onSymbolClick = {})
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
            onWeightUnitClick = {},
            onHeightUnitClick = {}
        )
    }
}