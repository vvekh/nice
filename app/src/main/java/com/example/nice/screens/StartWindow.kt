package com.example.nice.screens

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.nice.R
import com.example.nice.navigation.Screen

@Composable
fun StartWindow(navController: NavHostController){
    var selectedRole by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()){
        Image(painter = painterResource(id = R.drawable.backk), contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize())
    }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center) {
        Column(modifier = Modifier
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.welcome_pic), contentDescription = "image",
                modifier = Modifier
                    .size(300.dp)
                    .padding(bottom = 10.dp))
            Text(text = "Здравствуйте! Вы...", fontSize = 25.sp, color = colorResource(id = R.color.white),
                fontWeight = FontWeight.Bold)
            Button(onClick = {selectedRole = "Client"
                navController.navigate(Screen.SignInWindow.selectedRole(selectedRole))},
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.purple)),
                modifier = Modifier.padding(top = 20.dp),
                elevation = ButtonDefaults.buttonElevation(5.dp)) {
                Text(text = "Клиент", fontSize = 20.sp, color = colorResource(id = R.color.white))
            }
            Button(onClick = {selectedRole = "Specialist"
                navController.navigate(Screen.SignInWindow.selectedRole(selectedRole))},
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.purple)),
                modifier = Modifier.padding(top = 20.dp),
                elevation = ButtonDefaults.buttonElevation(5.dp)) {
                Text(text = "Специалист", fontSize = 20.sp, color = colorResource(id = R.color.white))
            }

        }
    }
}
