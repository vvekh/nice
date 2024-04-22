package com.example.nice.screens.profile

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nice.R

@Composable
fun PointSample(content: String){
    Card(modifier = Modifier.padding(10.dp),
        shape = RoundedCornerShape(25.dp),
        elevation = CardDefaults.elevatedCardElevation(5.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.purple))
    ) {
        Text(modifier = Modifier.padding(15.dp, 10.dp, 15.dp, 10.dp),
            text = content,
            color = colorResource(id = R.color.white),
            fontSize = 15.sp, fontWeight = FontWeight.Bold)
    }
}