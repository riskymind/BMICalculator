package com.asterisk.bmicalculator.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asterisk.bmicalculator.R
import com.asterisk.bmicalculator.ui.theme.BMICalculatorTheme
import com.asterisk.bmicalculator.ui.theme.CustomGray
import com.asterisk.bmicalculator.ui.theme.CustomOrange

@Composable
fun ColumnScope.SymbolButton(
    symbol: String,
    onSymbolClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .padding(20.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(CustomGray)
            .clickable(onClick = onSymbolClick)
            .padding(15.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = symbol, fontSize = 26.sp)
    }
}

@Composable
fun ColumnScope.SymbolButtonWithIcon(
    onSymbolClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .padding(20.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(CustomGray)
            .clickable(onClick = onSymbolClick)
            .padding(15.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_backspace),
            contentDescription = "Backspace Icon",
            tint = CustomOrange
        )
    }
}


@Preview(showBackground = true)
@Composable
fun SymbolButtonPreview() {
    BMICalculatorTheme {
        Column {
            SymbolButton(symbol = "AC", onSymbolClick = {})
        }
    }
}