package com.selimtoksal.quantitypicker

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
internal fun QuantityText(
    quantityData: QuantityData,
    style: TextStyle,
    modifier: Modifier,
    showLoading: Boolean,
    progressColor: Color
) {
    if (showLoading) {
        CircularProgressIndicator(modifier = Modifier.size(16.dp), strokeWidth = 2.dp, color = progressColor)
    } else {
        Text(
            text = "${quantityData.currentQuantity}${quantityData.quantityPostfix}",
            style = style,
            modifier = modifier,
        )
    }
}