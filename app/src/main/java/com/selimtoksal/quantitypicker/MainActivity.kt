package com.selimtoksal.quantitypicker

import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import com.selimtoksal.quantitypicker.ui.theme.MyQuantityPickerPrimaryColor
import com.selimtoksal.quantitypicker.ui.theme.QuantityPickerTheme
import com.selimtoksal.quantitypicker.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuantityPickerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        ProductCard1()
                        ProductCard2()
                    }
                }
            }
        }
    }
}

@Composable
fun ProductCard1() {

    //should implement viewmodel for quantity, loading and button clicks in real world
    var quantityData by remember { mutableStateOf(QuantityData()) }
    var isLoading by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(16.dp)
            .size(width = 150.dp, height = 190.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(contentAlignment = Alignment.TopEnd) {
                Image(
                    painter = painterResource(id = R.drawable.image_ahenk),
                    contentDescription = "chocolate image",
                    modifier = Modifier.size(120.dp)
                )
                QuantityPicker(
                    textStyle = Typography.body2,
                    quantityData = quantityData,
                    addIconResId = R.drawable.ic_plus,
                    subtractIconResId = R.drawable.ic_minus,
                    quantityPickerShape = QuantityPickerShape(
                        shape = RoundedCornerShape(50),
                        borderColor = MyQuantityPickerPrimaryColor,
                        borderWidth = 1.dp
                    ),
                    removeIconResId = R.drawable.ic_remove,
                    quantityTextModifier = Modifier
                        .background(
                            color = Color("#e1f6dd".toColorInt()),
                            shape = CircleShape
                        )
                        .padding(vertical = 4.dp, horizontal = 8.dp),
                    showLoading = isLoading,
                    progressColor = MyQuantityPickerPrimaryColor,
                    onAddClick = {
                        isLoading = true
                        Handler().postDelayed({
                            quantityData =
                                quantityData.copy(currentQuantity = quantityData.currentQuantity + 1)
                            isLoading = false
                        }, 500L)
                    },
                    onSubtractClick = {
                        isLoading = true
                        Handler().postDelayed({
                            quantityData =
                                quantityData.copy(currentQuantity = quantityData.currentQuantity - 1)
                            isLoading = false
                        }, 500L)
                    }
                )
            }
            Text(
                text = "Delicious Chocolate",
                modifier = Modifier.padding(
                    top = 16.dp,
                    start = 8.dp,
                    end = 8.dp
                ),
                style = Typography.subtitle2
            )
        }
    }
}

@Composable
fun ProductCard2() {

    //should implement viewmodel for quantity, loading and button clicks in real world
    var quantityData2 by remember { mutableStateOf(QuantityData(quantityPostfix = " gr")) }
    var isLoading2 by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(16.dp)
            .size(width = 150.dp, height = 190.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(contentAlignment = Alignment.BottomEnd) {
                Image(
                    painter = painterResource(id = R.drawable.image_potatoes),
                    contentDescription = "potatoes image",
                    modifier = Modifier.size(120.dp)
                )
                QuantityPicker(
                    textStyle = Typography.body2,
                    quantityData = quantityData2,
                    addIconResId = R.drawable.ic_plus,
                    subtractIconResId = R.drawable.ic_minus,
                    direction = QuantityPickerDirection.HORIZONTAL,
                    quantityPickerShape = QuantityPickerShape(
                        shape = RoundedCornerShape(20),
                        borderColor = Color.LightGray,
                        borderWidth = 1.dp
                    ),
                    quantityTextModifier = Modifier
                        .border(
                            width = 1.dp,
                            shape = RoundedCornerShape(20),
                            color = Color.LightGray
                        )
                        .padding(vertical = 4.dp, horizontal = 8.dp),
                    showLoading = isLoading2,
                    progressColor = Color.LightGray,
                    onAddClick = {
                        isLoading2 = true
                        Handler().postDelayed({
                            quantityData2 =
                                quantityData2.copy(currentQuantity = quantityData2.currentQuantity + 250)
                            isLoading2 = false
                        }, 500L)
                    },
                    onSubtractClick = {
                        isLoading2 = true
                        Handler().postDelayed({
                            quantityData2 =
                                quantityData2.copy(currentQuantity = quantityData2.currentQuantity - 250)
                            isLoading2 = false
                        }, 500L)
                    }
                )
            }
            Text(
                text = "Sweet Potatoes",
                modifier = Modifier.padding(
                    top = 16.dp,
                    start = 8.dp,
                    end = 8.dp
                ),
                style = Typography.subtitle2
            )
        }
    }
}

