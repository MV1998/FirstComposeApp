package com.example.practicecompose1.data

import androidx.compose.ui.graphics.Brush

data class CardModel(
    val cardType : String,
    val cardNumber : String,
    val balance : Double,
    val cardName : String,
    val color : Brush
)
