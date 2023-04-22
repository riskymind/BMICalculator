package com.asterisk.bmicalculator.ui.bmi

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.asterisk.bmicalculator.components.BottomSheetContent
import com.asterisk.bmicalculator.ui.bmi_actions.BmiEvents
import com.asterisk.bmicalculator.ui.bmi_viewmodel.BmiScreenViewModel
import com.asterisk.bmicalculator.ui.theme.BMICalculatorTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BmiScreen() {

    val viewModel = viewModel<BmiScreenViewModel>()

    val coroutineScope = rememberCoroutineScope()
    val bottomModalState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true
    )

    ModalBottomSheetLayout(
        sheetState = bottomModalState,
        sheetContent = {
            BottomSheetContent(
                sheetTitle = viewModel.state.bottomSheetTitle,
                sheetItems = viewModel.state.bottomSheetItems,
                onCancelClick = {
                    coroutineScope.launch { bottomModalState.hide() }
                },
            )
        },
        sheetBackgroundColor = Color.White,
        sheetShape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),
        content = {
            BMIScreenContent(
                onWeightUnitClick = {
                    coroutineScope.launch { bottomModalState.show() }
                    viewModel.onEvent(BmiEvents.OnWeightTextClick)
                },
                onHeightUnitClick = {
                    coroutineScope.launch { bottomModalState.show() }
                    viewModel.onEvent(BmiEvents.OnHeightTextClick)
                }
            )
        }
    )
}


@Preview(showBackground = true)
@Composable
fun BMIScreenPreview() {
    BMICalculatorTheme {
        BmiScreen()
    }
}