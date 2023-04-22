package com.asterisk.bmicalculator.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.asterisk.bmicalculator.ui.theme.BMICalculatorTheme

@Composable
fun NumberKeyboard(
    modifier: Modifier = Modifier,
    onNumberClick: (String) -> Unit,
) {
    Column(modifier = modifier) {
        val numberButtonList = listOf<String>(
            "7", "8", "9", "4", "5", "6",
            "1", "2", "3", "", "0", "."
        )

        LazyVerticalGrid(columns = GridCells.Fixed(3)) {
            items(numberButtonList) { item ->
                NumberButton(
                    number = item,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onNumberClick = onNumberClick
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NumberKeyboardPreview() {
    BMICalculatorTheme {
        NumberKeyboard(onNumberClick = {})
    }
}