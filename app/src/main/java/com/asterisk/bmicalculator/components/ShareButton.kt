package com.asterisk.bmicalculator.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asterisk.bmicalculator.ui.theme.BMICalculatorTheme
import com.asterisk.bmicalculator.ui.theme.CustomOrange

@Composable
fun ShareButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = CustomOrange,
            contentColor = Color.White
        ),
        onClick = onClick
    ) {
        Text(text = "Share", modifier = Modifier.padding(10.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ShareButtonPreview() {
    BMICalculatorTheme {
        ShareButton() {}
    }
}