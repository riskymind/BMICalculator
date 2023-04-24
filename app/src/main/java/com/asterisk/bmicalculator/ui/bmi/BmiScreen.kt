package com.asterisk.bmicalculator.ui.bmi

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asterisk.bmicalculator.components.BottomSheetContent
import com.asterisk.bmicalculator.ui.bmi_actions.BmiEvents
import com.asterisk.bmicalculator.ui.bmi_state.BmiScreenState
import com.asterisk.bmicalculator.ui.theme.BMICalculatorTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BmiScreen(
    bmiScreenState: BmiScreenState,
    onEvent: (BmiEvents) -> Unit,
) {
    val context = LocalContext.current

    val coroutineScope = rememberCoroutineScope()
    val bottomModalState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true
    )

    ModalBottomSheetLayout(
        sheetState = bottomModalState,
        sheetContent = {
            BottomSheetContent(
                sheetTitle = bmiScreenState.bottomSheetTitle,
                sheetItems = bmiScreenState.bottomSheetItems,
                onCancelClick = {
                    coroutineScope.launch { bottomModalState.hide() }
                },

                onItemClick = {
                    coroutineScope.launch { bottomModalState.hide() }
                    onEvent(BmiEvents.BottomSheetItemSelected(it))
                }
            )
        },
        sheetBackgroundColor = Color.White,
        sheetShape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),
        content = {
            BMIScreenContent(
                state = bmiScreenState,
                onWeightUnitClick = {
                    coroutineScope.launch { bottomModalState.show() }
                    onEvent(BmiEvents.OnWeightTextClick)
                },
                onHeightUnitClick = {
                    coroutineScope.launch { bottomModalState.show() }
                    onEvent(BmiEvents.OnHeightTextClick)
                },
                onWeightValueClick = {
                    onEvent(BmiEvents.OnWeightValueClick)
                },

                onHeightValueClick = {
                    onEvent(BmiEvents.OnHeightValueClick)
                },
                onNumberClick = {
                    onEvent(BmiEvents.OnNumberClick(it))
                },
                onAllClearClick = {
                    onEvent(BmiEvents.AllClearButtonClick)
                },
                onBackSpaceClick = {
                    onEvent(BmiEvents.BackSpaceClick)
                },
                onGoClick = {
                    onEvent(BmiEvents.OnGoClick(context))
                },
                onShareClick = {
                    shareBmiResult(bmiScreenState.bmi,
                        bmiScreenState.bmiStage,
                        context)
                }
            )
        }
    )
}

fun shareBmiResult(bmi: Double, bmiStage: String, context: Context) {
    val sendIntent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT,
            "Hey Guys! Checkout my Body Mass Index: $bmi BMI,which is considered $bmiStage")
        type = "text/plain"
    }

    val shareIntent = Intent.createChooser(sendIntent, null)

    context.startActivity(shareIntent)
}


@Preview(showBackground = true)
@Composable
fun BMIScreenPreview() {
    BMICalculatorTheme {
        BmiScreen(
            BmiScreenState(),
            {}
        )
    }

}