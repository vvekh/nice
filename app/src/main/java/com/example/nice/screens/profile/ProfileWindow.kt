package com.example.nice.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.nice.screens.GetLocalClient


@Composable
fun ProfileWindow(navController: NavHostController, role: String){
    var selectedRole = role
    val cl = GetLocalClient()

    if(selectedRole == "Client"){
        ClientProfile()
    }else if(selectedRole == "Specialist"){
        SpecialistProfile()
    }
}

@Preview (showSystemUi = true)
@Composable
fun ClientProfile(){
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
            Text(modifier = Modifier.padding(top = 15.dp),
                color = colorResource(id = R.color.purple),
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                text = "client_login")
            Text(color = colorResource(id = R.color.purple),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                text = "Username, age")



            Button(onClick = {},
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.purple)),
                modifier = Modifier.padding(top = 20.dp),
                elevation = ButtonDefaults.buttonElevation(5.dp)) {
                Text(text = "Выйти", fontSize = 20.sp, color = colorResource(id = R.color.white))
            }
        }
    }
}

@Composable
fun SpecialistProfile(){

}