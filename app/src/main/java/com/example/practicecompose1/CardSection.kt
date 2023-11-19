package com.example.practicecompose1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicecompose1.data.CardModel
import com.example.practicecompose1.ui.theme.BlueEnd
import com.example.practicecompose1.ui.theme.BlueStart
import com.example.practicecompose1.ui.theme.GreenEnd
import com.example.practicecompose1.ui.theme.GreenStart
import com.example.practicecompose1.ui.theme.OrangeEnd
import com.example.practicecompose1.ui.theme.OrangeStart
import com.example.practicecompose1.ui.theme.PurpleEnd
import com.example.practicecompose1.ui.theme.PurpleStart

val cardItems = listOf<CardModel>(
    CardModel(
        cardType = "VISA",
        cardNumber = "3432 3544 4542 2343",
        cardName = "Business",
        balance = 33.13,
        color = getGradient(PurpleStart, PurpleEnd)
    ),
    CardModel(
        cardType = "MASTER CARD",
        cardNumber = "3432 3544 4542 3212",
        cardName = "Savings",
        balance = 133.13,
        color = getGradient(BlueStart, BlueEnd)
    ),
    CardModel(
        cardType = "VISA",
        cardNumber = "3432 3544 4542 2343",
        cardName = "School",
        balance = 233.13,
        color = getGradient(OrangeStart, OrangeEnd)
    ),
    CardModel(
        cardType = "VISA",
        cardNumber = "3432 3544 4542 2343",
        cardName = "Trips",
        balance = 354.13,
        color = getGradient(GreenStart, GreenEnd)
    )
)

@Preview
@Composable
fun CardSection() {
    LazyRow() {
        items(cardItems.size) {index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(index : Int) {
    val card = cardItems[index]
    var lastItemPaddingEnd = 0.dp
    if (index == cardItems.size - 1) {
        lastItemPaddingEnd = 16.dp
    }

    val image = painterResource(id = R.drawable.ic_launcher_background)

    Box(
        modifier = Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(brush = card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable { }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(card.cardType,
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold)
//            Image(painter = image, contentDescription = card.cardName,
//                modifier = Modifier.size(10.dp))
            Spacer(modifier = Modifier.size(10.dp))
            Text(card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold)
            Text("\$ ${card.balance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
           )
        }
    }
}

fun getGradient(startColor : Color, endColor : Color) : Brush {
    return Brush.horizontalGradient(colors = listOf(startColor, endColor))
}