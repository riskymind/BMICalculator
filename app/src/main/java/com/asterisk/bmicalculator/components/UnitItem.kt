package com.asterisk.bmicalculator.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.asterisk.bmicalculator.ui.theme.BMICalculatorTheme

@Composable
fun UnitItem(
    unitType: String,
    textColor: Color = Color.Black,
    onUnitClick: () -> Unit,
) {
    Row(
        modifier = Modifier.clickable(onClick = onUnitClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = unitType,
            fontSize = 22.sp,
            color = textColor
        )

        Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Select unit")
    }
}


@Preview(showBackground = true)
@Composable
fun UnitItemPreview() {
    BMICalculatorTheme {
        UnitItem(
            unitType = "Weight",
            onUnitClick = {}
        )
    }
}