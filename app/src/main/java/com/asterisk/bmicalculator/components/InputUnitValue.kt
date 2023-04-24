package com.asterisk.bmicalculator.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.asterisk.bmicalculator.ui.theme.CustomOrange

@Composable
fun InputUnitValue(
    unitValue: String,
    unit: String,
    inputColor: Color,
    onUnitValueClick: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.End
    ) {
        Text(
            text = unitValue,
            fontSize = 40.sp,
            color = inputColor,
            modifier = Modifier.clickable { onUnitValueClick() }
        )
        Text(text = unit, fontSize = 12.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun InputUnitValuePreview() {
    InputUnitValue(
        unitValue = "60",
        unit = "Kilogram",
        inputColor = CustomOrange,
        onUnitValueClick = {}
    )
}