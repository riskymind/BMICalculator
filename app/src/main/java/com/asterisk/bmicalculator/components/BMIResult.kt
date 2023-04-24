package com.asterisk.bmicalculator.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asterisk.bmicalculator.ui.theme.*

@Composable
fun BmiResult(
    bmi: Double,
    bmiState: String,
    bmiStateColor: Color = Color.Green,
) {
    Column(
        modifier = Modifier
            .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(15.dp))
            .clip(RoundedCornerShape(15.dp))
            .background(Color.White)
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = bmi.toString(),
                fontSize = 70.sp,
                fontWeight = FontWeight.Bold,
                color = CustomOrange
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = "Bmi", fontSize = 40.sp, color = CustomGray)
                Text(text = bmiState, fontSize = 18.sp, color = bmiStateColor)
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Divider(
            modifier = Modifier
                .background(Color.Gray)
                .shadow(elevation = 5.dp),
            thickness = 5.dp
        )

        Text(
            text = "Information",
            fontSize = 20.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 25.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "Underweight", color = CustomBlue)
            Text(text = "Normal", color = CustomGreen)
            Text(text = "Overweight", color = CustomRed)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Divider(
                modifier = Modifier
                    .weight(1f)
                    .background(CustomBlue),
                thickness = 5.dp
            )
            Divider(
                modifier = Modifier
                    .weight(1f)
                    .background(CustomGreen),
                thickness = 5.dp
            )
            Divider(
                modifier = Modifier
                    .weight(1f)
                    .background(CustomRed),
                thickness = 5.dp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "16.0", fontSize = 18.sp, color = Color.DarkGray)
            Text(text = "18.5", fontSize = 18.sp, color = Color.DarkGray)
            Text(text = "25.0", fontSize = 18.sp, color = Color.DarkGray)
            Text(text = "40.0", fontSize = 18.sp, color = Color.DarkGray)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BmiResultPreview() {
    BMICalculatorTheme {
        BmiResult(
            bmi = 24.5,
            bmiState = "Normal"
        )
    }
}