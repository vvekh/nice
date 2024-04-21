package com.example.nice.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.nice.R


@Composable
fun ProfileWindow(navController: NavHostController){

    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()){
        Image(painter = painterResource(id = R.drawable.backk), contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize())
    }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center) {
        Column(modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
        }
    }
}

@Preview (showSystemUi = true)
@Composable
fun ProfileWindow1(){
    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()){
        Image(painter = painterResource(id = R.drawable.backk), contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize())
    }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center) {
        Column(modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.client_pic), contentDescription = null,
                modifier = Modifier.size(150.dp))
        }
    }
}