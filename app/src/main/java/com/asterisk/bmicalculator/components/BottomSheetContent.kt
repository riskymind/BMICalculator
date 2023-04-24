package com.asterisk.bmicalculator.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asterisk.bmicalculator.ui.theme.BMICalculatorTheme

@Composable
fun BottomSheetContent(
    sheetTitle: String,
    sheetItems: List<String>,
    onCancelClick: () -> Unit,
    onItemClick: (String) -> Unit,
) {

    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        text = sheetTitle,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )

    sheetItems.forEach { item ->
        Box(modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(item) }) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = item
            )
        }
    }

    Button(
        onClick = onCancelClick,
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.LightGray,
            contentColor = Color.Black
        )
    ) {
        Text(text = "Cancel")
    }


}


@Preview(showBackground = true)
@Composable
fun BottomSheetContentPreview() {
    BMICalculatorTheme {
        Column {

            BottomSheetContent(
                sheetTitle = "Weight",
                sheetItems = listOf("Kilogram", "Pounds"),
                onCancelClick = {},
                onItemClick = {}
            )
        }
    }
}