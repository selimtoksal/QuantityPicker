package com.selimtoksal.quantitypicker

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class QuantityPickerShape(
    val shape: Shape = RoundedCornerShape(20),
    val borderWidth: Dp = 2.dp,
    val borderColor: Color = Color.LightGray,
    val backgroundColor: Color = Color.White
)