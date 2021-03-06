package com.selimtoksal.quantitypicker

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
internal fun QuantityAddIcon(
    @DrawableRes addIconResId: Int,
    addIconContentDescription: String?,
    showLoading: Boolean,
    onAddClick: (() -> Unit)?
) {
    Icon(
        painter = painterResource(id = addIconResId),
        contentDescription = addIconContentDescription,
        modifier = Modifier
            .clickable(
                enabled = showLoading.not(),
                onClick = { onAddClick?.invoke() },
                interactionSource = MutableInteractionSource(),
                indication = null,
            )
            .padding(8.dp),
        tint = Color.Unspecified
    )
}