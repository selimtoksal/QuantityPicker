package com.selimtoksal.quantitypicker

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun QuantityPicker(
    modifier: Modifier = Modifier,
    quantityTextModifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    @DrawableRes addIconResId: Int = R.drawable.ic_quantity_picker_add_default,
    @DrawableRes subtractIconResId: Int = R.drawable.ic_quantity_picker_subtract_default,
    @DrawableRes removeIconResId: Int? = null,
    quantityPickerShape: QuantityPickerShape = QuantityPickerShape(),
    quantityData: QuantityData,
    showLoading: Boolean = false,
    addIconContentDescription: String? = null,
    subtractIconContentDescription: String? = null,
    progressColor: Color = Color.Magenta,
    direction: QuantityPickerDirection = QuantityPickerDirection.VERTICAL,
    onAddClick: (() -> Unit)? = null,
    onSubtractClick: (() -> Unit)? = null
) {

    when (direction) {
        QuantityPickerDirection.VERTICAL -> SetupVertical(
            modifier = modifier,
            quantityTextModifier = quantityTextModifier,
            textStyle = textStyle,
            addIconResId = addIconResId,
            subtractIconResId = subtractIconResId,
            removeIconResId = removeIconResId,
            quantityPickerShape = quantityPickerShape,
            quantityData = quantityData,
            showLoading = showLoading,
            addIconContentDescription = addIconContentDescription,
            subtractIconContentDescription = subtractIconContentDescription,
            progressColor = progressColor,
            onAddClick = onAddClick,
            onSubtractClick = onSubtractClick,
        )
        QuantityPickerDirection.HORIZONTAL -> SetupHorizontal(
            modifier = modifier,
            quantityTextModifier = quantityTextModifier,
            textStyle = textStyle,
            addIconResId = addIconResId,
            subtractIconResId = subtractIconResId,
            removeIconResId = removeIconResId,
            quantityPickerShape = quantityPickerShape,
            quantityData = quantityData,
            showLoading = showLoading,
            addIconContentDescription = addIconContentDescription,
            subtractIconContentDescription = subtractIconContentDescription,
            progressColor = progressColor,
            onAddClick = onAddClick,
            onSubtractClick = onSubtractClick,
        )
    }
}

@Composable
internal fun SetupVertical(
    modifier: Modifier,
    quantityTextModifier: Modifier = Modifier,
    textStyle: TextStyle,
    @DrawableRes addIconResId: Int,
    @DrawableRes subtractIconResId: Int,
    @DrawableRes removeIconResId: Int?,
    quantityPickerShape: QuantityPickerShape,
    quantityData: QuantityData,
    showLoading: Boolean,
    addIconContentDescription: String?,
    subtractIconContentDescription: String?,
    progressColor: Color,
    onAddClick: (() -> Unit)?,
    onSubtractClick: (() -> Unit)?
) {

    Column(
        modifier = modifier.border(
            width = quantityPickerShape.borderWidth,
            color = quantityPickerShape.borderColor,
            shape = quantityPickerShape.shape
        ).background(
            color = quantityPickerShape.backgroundColor,
            shape = quantityPickerShape.shape
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        QuantityAddIcon(
            addIconResId = addIconResId,
            addIconContentDescription = addIconContentDescription,
            showLoading = showLoading,
            onAddClick = onAddClick
        )

        AnimatedVisibility(visible = quantityData.currentQuantity > 0 || showLoading) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                QuantityText(
                    quantityData = quantityData,
                    style = textStyle,
                    modifier = quantityTextModifier,
                    showLoading = showLoading,
                    progressColor = progressColor
                )
                QuantitySubtractIcon(
                    subtractIconResId = subtractIconResId,
                    subtractIconContentDescription = subtractIconContentDescription,
                    showLoading = showLoading,
                    onSubtractClick = onSubtractClick,
                    removeIconResId = removeIconResId,
                    currentQuantity = quantityData.currentQuantity
                )
            }
        }
    }
}

@Composable
internal fun SetupHorizontal(
    modifier: Modifier = Modifier,
    quantityTextModifier: Modifier,
    textStyle: TextStyle,
    @DrawableRes addIconResId: Int,
    @DrawableRes subtractIconResId: Int,
    @DrawableRes removeIconResId: Int?,
    quantityPickerShape: QuantityPickerShape,
    quantityData: QuantityData,
    showLoading: Boolean,
    addIconContentDescription: String?,
    subtractIconContentDescription: String?,
    progressColor: Color,
    onAddClick: (() -> Unit)?,
    onSubtractClick: (() -> Unit)?
) {

    Row(
        modifier = modifier.border(
            width = quantityPickerShape.borderWidth,
            color = quantityPickerShape.borderColor,
            shape = quantityPickerShape.shape
        ).background(
            color = quantityPickerShape.backgroundColor,
            shape = quantityPickerShape.shape
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        AnimatedVisibility(visible = quantityData.currentQuantity > 0 || showLoading) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                QuantitySubtractIcon(
                    subtractIconResId = subtractIconResId,
                    subtractIconContentDescription = subtractIconContentDescription,
                    showLoading = showLoading,
                    onSubtractClick = onSubtractClick,
                    removeIconResId = removeIconResId,
                    currentQuantity = quantityData.currentQuantity
                )
                QuantityText(
                    quantityData = quantityData,
                    style = textStyle,
                    modifier = quantityTextModifier,
                    showLoading = showLoading,
                    progressColor = progressColor
                )
            }
        }
        QuantityAddIcon(
            addIconResId = addIconResId,
            addIconContentDescription = addIconContentDescription,
            showLoading = showLoading,
            onAddClick = onAddClick
        )
    }
}