package com.example.nice.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.nice.R
import com.example.nice.models.Client
import com.google.gson.Gson


@Composable
fun ProfileWindow(navController: NavHostController, client: String){
    val activeClient: Client = Gson().fromJson(client, Client::class.java)

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
            Text(text = activeClient.id.toString())
            Text(text = activeClient.login.toString())
            Text(text = activeClient.password.toString())
            Text(text = activeClient.username.toString())
            Text(text = activeClient.birthdate.toString())
        }
    }
}

@Preview (showSystemUi = true)
@Composable
fun ProfileWindow1(){
    val activeClient: Client = Client()
    activeClient.id = 0
    activeClient.username = "София"
    activeClient.login = "vvekhova"
    activeClient.password = "password"
    activeClient.birthdate = "2004-04-29"
    activeClient.timelineid = 1

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
            Text(text = activeClient.login.toString(),
                modifier = Modifier.padding(top = 20.dp),
                color = colorResource(id = R.color.purple),
                fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                Text(text = activeClient.username.toString() + activeClient.birthdate.toString(),
                    color = colorResource(id = R.color.purple),
                    fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }
    }
}