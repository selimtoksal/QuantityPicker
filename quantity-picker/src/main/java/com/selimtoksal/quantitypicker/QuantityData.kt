package com.selimtoksal.quantitypicker

data class QuantityData(
    val minQuantity: Int = 0,
    val maxQuantity: Int = 0,
    val currentQuantity: Int = 0,
    val quantityPostfix: String = ""
)
