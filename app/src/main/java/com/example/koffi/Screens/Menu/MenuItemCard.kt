package com.example.koffi.Screens.Menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.koffi.Models.Drink
import com.example.koffi.R
import com.example.koffi.ui.theme.bgSpecialGray

@Composable
fun MenuItemCard(
    drink: Drink,
    onClick: ()->Unit
) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(10.dp)
            ), //TODO
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            contentColor = Color.Black,
            containerColor = bgSpecialGray
        ),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row (
            modifier = Modifier.padding(12.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.koffi_logo),
                contentDescription = "image",
                modifier = Modifier.size(72.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column{
                Text(text = drink.name, fontWeight = FontWeight.Bold)
                Text(text = drink.description)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Rs. ${drink.price}")
            }
        }
    }
}