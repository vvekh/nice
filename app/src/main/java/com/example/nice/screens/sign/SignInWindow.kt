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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.nice.R
import com.example.nice.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInWindow(navController: NavHostController, role : String) {
    val viewModel: SignViewModel = viewModel()
    var selectedRole = role

    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
    ) {
        Image(modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.backk), contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Column(modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(modifier = Modifier
                .size(300.dp)
                .padding(bottom = 10.dp),
                painter = painterResource(id = R.drawable.welcome_pic), contentDescription = null
            )
            Column(modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(value = viewModel.clientLogin,
                    onValueChange = { viewModel.ClientLoginUpdate(it) },
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
                            modifier = Modifier.size(20.dp)
                        )
                    }
                )
                OutlinedTextField(value = viewModel.clientPassword, onValueChange = { viewModel.ClientPasswordUpdate(it) },
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
                        Icon(
                            painter = painterResource(id = R.drawable.lock),
                            contentDescription = "",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                )
                Button(onClick = {
                    viewModel.Authorization(navController, role)
                    navController.navigate(Screen.ProfileWindow.selectedRole(role))
                                 },
                    modifier = Modifier.padding(top = 20.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.siren)),
                    elevation = ButtonDefaults.buttonElevation(5.dp)
                ) {
                    Text(text = "Войти",
                        fontSize = 20.sp,
                        color = colorResource(id = R.color.white)
                    )
                }
            }
            Text(modifier = Modifier
                .clickable {
                    navController.navigate(
                        Screen.SignUpWindow.selectedRole(
                            selectedRole
                        )
                    )
                }
                .padding(top = 10.dp),
                color = colorResource(id = R.color.gray),
                fontWeight = FontWeight.Bold,
                text = "Ещё нет аккаунта? Зарегистрируйтесь")
        }
    }
}