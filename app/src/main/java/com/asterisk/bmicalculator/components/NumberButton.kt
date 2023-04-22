package com.asterisk.bmicalculator.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asterisk.bmicalculator.ui.theme.BMICalculatorTheme

@Composable
fun NumberButton(
    modifier: Modifier = Modifier,
    number: String,
    onNumberClick: (String) -> Unit,
) {
    Box(
        modifier = modifier
            .padding(10.dp)
            .clip(CircleShape)
            .clickable { onNumberClick(number) },
        contentAlignment = Alignment.Center
    ) {
        Text(text = number, fontSize = 40.sp)
    }
}


@Preview(showBackground = true)
@Composable
fun NumberButtonPreview() {
    BMICalculatorTheme {
        NumberButton(number = "7", onNumberClick = {})
    }
}