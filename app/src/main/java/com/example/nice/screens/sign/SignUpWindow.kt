package com.example.nice.screens.sign

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.nice.R


@Composable
fun SingUpWindow(navController: NavHostController, role : String){
    var selectedRole = role
    if(selectedRole == "Client"){
        ClientReg()
    }else if(selectedRole == "Specialist"){
        SpecialistReg()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientReg(){
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
            Image(painter = painterResource(id = R.drawable.welcome_pic), contentDescription = "image",
                modifier = Modifier
                    .size(300.dp)
                    .padding(bottom = 10.dp))
            Column(modifier = Modifier
                .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                OutlinedTextField(value = login, onValueChange = {login = it},
                    label = { Text("Введите логин") },
                    shape = RoundedCornerShape(20.dp),
                    textStyle = TextStyle(fontSize = 17.sp),
                    colors = outlinedTextFieldColors(
                        focusedBorderColor = colorResource(id = R.color.purple),
                        focusedLabelColor = colorResource(id = R.color.purple),
                        focusedLeadingIconColor = colorResource(id = R.color.purple),
                    ),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.user),
                            contentDescription = "",
                            modifier = Modifier.size(20.dp))
                    }
                )
                OutlinedTextField(value = password, onValueChange = {password = it},
                    label = { Text("Введите пароль") },
                    shape = RoundedCornerShape(20.dp),
                    textStyle = TextStyle(fontSize = 17.sp),
                    visualTransformation = PasswordVisualTransformation(),
                    colors = outlinedTextFieldColors(
                        focusedBorderColor = colorResource(id = R.color.purple),
                        focusedLabelColor = colorResource(id = R.color.purple),
                        focusedLeadingIconColor = colorResource(id = R.color.purple),
                    ),
                    leadingIcon = {
                        Icon(painter = painterResource(id = R.drawable.lock), contentDescription = "",
                            modifier = Modifier.size(20.dp))
                    }
                )
                Button(onClick = {},
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.siren)),
                    modifier = Modifier.padding(top = 20.dp),
                    elevation = ButtonDefaults.buttonElevation(5.dp)) {
                    Text(text = "Зарегистрироваться", fontSize = 20.sp, color = colorResource(id = R.color.white))
                }
            }
            Text(modifier = Modifier.clickable {}
                .padding(top = 10.dp),
                color = colorResource(id = R.color.gray),
                fontWeight = FontWeight.Bold,
                text = "Уже есть аккаунт? Войдите")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpecialistReg(){
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
            Image(painter = painterResource(id = R.drawable.welcome_pic), contentDescription = "image",
                modifier = Modifier
                    .size(300.dp)
                    .padding(bottom = 10.dp))
            Column(modifier = Modifier
                .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                OutlinedTextField(value = login, onValueChange = {login = it},
                    label = { Text("Введите логин") },
                    shape = RoundedCornerShape(20.dp),
                    textStyle = TextStyle(fontSize = 17.sp),
                    colors = outlinedTextFieldColors(
                        focusedBorderColor = colorResource(id = R.color.purple),
                        focusedLabelColor = colorResource(id = R.color.purple),
                        focusedLeadingIconColor = colorResource(id = R.color.purple),
                    ),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.user),
                            contentDescription = "",
                            modifier = Modifier.size(20.dp))
                    }
                )
                OutlinedTextField(value = password, onValueChange = {password = it},
                    label = { Text("Введите пароль") },
                    shape = RoundedCornerShape(20.dp),
                    textStyle = TextStyle(fontSize = 17.sp),
                    visualTransformation = PasswordVisualTransformation(),
                    colors = outlinedTextFieldColors(
                        focusedBorderColor = colorResource(id = R.color.purple),
                        focusedLabelColor = colorResource(id = R.color.purple),
                        focusedLeadingIconColor = colorResource(id = R.color.purple),
                    ),
                    leadingIcon = {
                        Icon(painter = painterResource(id = R.drawable.lock), contentDescription = "",
                            modifier = Modifier.size(20.dp))
                    }
                )
                Button(onClick = {},
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.siren)),
                    modifier = Modifier.padding(top = 20.dp),
                    elevation = ButtonDefaults.buttonElevation(5.dp)) {
                    Text(text = "Зарегистрироваться", fontSize = 20.sp, color = colorResource(id = R.color.white))
                }
            }
            Text(modifier = Modifier.clickable {}
                .padding(top = 10.dp),
                color = colorResource(id = R.color.gray),
                fontWeight = FontWeight.Bold,
                text = "Уже есть аккаунт? Войдите")
        }
    }
}