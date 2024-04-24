package com.example.nice.screens.sign

import android.content.Context
import android.widget.Toast
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
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.nice.R
import com.example.nice.templates.TimelinesDataResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


@Composable
fun SingUpWindow(navController: NavHostController, role : String){
    val viewModel = SignViewModel()
    var timelines by remember { mutableStateOf<List<TimelinesDataResponse>?>(null) }

    LaunchedEffect(Unit) {
        val pointsList = withContext(Dispatchers.IO) {
            viewModel.Timelines()
        }
        timelines = pointsList
    }

    if (timelines == null) {
        // Показываем какой-то индикатор загрузки, например, ProgressBar
    } else {
        var selectedRole = role
        if (selectedRole == "Client") {
            ClientReg(timelines!!)
        } else if (selectedRole == "Specialist") {
            SpecialistReg()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientReg(timelines: List<TimelinesDataResponse>){
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var password2 by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }

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
                            painter = painterResource(id = R.drawable.at),
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
                OutlinedTextField(value = password2, onValueChange = {password2 = it},
                    label = { Text("Повторите пароль") },
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
                OutlinedTextField(value = username, onValueChange = {username = it},
                    label = { Text("Введите имя") },
                    shape = RoundedCornerShape(20.dp),
                    textStyle = TextStyle(fontSize = 17.sp),
                    colors = outlinedTextFieldColors(
                        focusedBorderColor = colorResource(id = R.color.purple),
                        focusedLabelColor = colorResource(id = R.color.purple),
                        focusedLeadingIconColor = colorResource(id = R.color.purple),
                    ),
                    leadingIcon = {
                        Icon(painter = painterResource(id = R.drawable.user), contentDescription = "",
                            modifier = Modifier.size(20.dp))
                    }
                )
                DatePickerComponent()
                SpinnerComponent(timelines)

                Button(onClick = {},
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.purple)),
                    modifier = Modifier.padding(top = 20.dp),
                    elevation = ButtonDefaults.buttonElevation(5.dp)) {
                    Text(text = "Зарегистрироваться", fontSize = 20.sp, color = colorResource(id = R.color.white))
                }
            }
            Text(modifier = Modifier
                .clickable {}
                .padding(top = 10.dp),
                color = colorResource(id = R.color.gray),
                fontWeight = FontWeight.Bold,
                text = "Уже есть аккаунт? Войдите")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpecialistReg() {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.backk), contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.welcome_pic),
                contentDescription = "image",
                modifier = Modifier
                    .size(300.dp)
                    .padding(bottom = 10.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(value = login, onValueChange = { login = it },
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
                OutlinedTextField(value = password, onValueChange = { password = it },
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
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.siren)),
                    modifier = Modifier.padding(top = 20.dp),
                    elevation = ButtonDefaults.buttonElevation(5.dp)
                ) {
                    Text(
                        text = "Зарегистрироваться",
                        fontSize = 20.sp,
                        color = colorResource(id = R.color.white)
                    )
                }
            }
            Text(modifier = Modifier
                .clickable {}
                .padding(top = 10.dp),
                color = colorResource(id = R.color.gray),
                fontWeight = FontWeight.Bold,
                text = "Уже есть аккаунт? Войдите")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerComponent(){
    var date by remember { mutableStateOf("") }
    val context: Context = LocalContext.current
    val datePickerState = rememberDatePickerState()
    var showDatePicker by remember { mutableStateOf(false) }

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        OutlinedTextField(readOnly = true,
            value = date, onValueChange = {},
            label = { Text("Выберите дату") },
            shape = RoundedCornerShape(20.dp),
            textStyle = TextStyle(fontSize = 17.sp),
            colors = outlinedTextFieldColors(
                focusedBorderColor = colorResource(id = R.color.purple),
                focusedLabelColor = colorResource(id = R.color.purple),
                focusedLeadingIconColor = colorResource(id = R.color.purple),
            ),
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.calendar),
                    contentDescription = "",
                    modifier = Modifier
                        .size(20.dp)
                        .clickable { showDatePicker = true })
            }
        )
    }
    if(showDatePicker == true){
        DatePickerDialog(
            onDismissRequest = { /*TODO*/ },
            confirmButton = { TextButton(onClick = {
                val selectedDate = Calendar.getInstance().apply {
                    timeInMillis = datePickerState.selectedDateMillis!!
                    date = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(datePickerState.selectedDateMillis!!)
                    showDatePicker = false
                }
                if (selectedDate.after(Calendar.getInstance())) {
                    Toast.makeText(context, "Selected date ${selectedDate.time} saved", Toast.LENGTH_SHORT).show()
                    showDatePicker = false
                } else {
                    Toast.makeText(context, "Неверная дата", Toast.LENGTH_SHORT).show()
                } }) { Text("Сохранить") } },
            dismissButton = { TextButton(onClick = { showDatePicker = false }) { Text("Отменить") } },
            colors = DatePickerDefaults.colors(containerColor = colorResource(id = R.color.white)))
        {
            DatePicker(state = datePickerState,
                colors = DatePickerDefaults.colors(
                    todayContentColor = colorResource(id = R.color.purple),
                    todayDateBorderColor = colorResource(id = R.color.purple),
                    selectedDayContentColor = colorResource(id = R.color.white),
                    dayContentColor = colorResource(id = R.color.purple),
                    selectedDayContainerColor = colorResource(id = R.color.purple)
                ))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpinnerComponent(times: List<TimelinesDataResponse>){
    val stringList = mutableListOf<String>()
    times.forEach {
        if (it != null) {
            var itt: String = it.timelinename.toString()
            stringList.add(itt)
        }
    }
    var expandedState by remember { mutableStateOf(true) }
    var selectedItem by remember { mutableStateOf(stringList[0]) }
    var mContext = LocalContext.current

    ExposedDropdownMenuBox(expanded = expandedState,
        onExpandedChange = {expandedState = !expandedState}) {
        OutlinedTextField(
            label = { Text("Выберите часовой пояс") },
            shape = RoundedCornerShape(20.dp),
            textStyle = TextStyle(fontSize = 17.sp),
            colors = outlinedTextFieldColors(
                focusedBorderColor = colorResource(id = R.color.purple),
                focusedLabelColor = colorResource(id = R.color.purple),
                focusedLeadingIconColor = colorResource(id = R.color.purple),
            ),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.clock),
                    contentDescription = "",
                    modifier = Modifier
                        .size(20.dp).clickable { expandedState = true })
            },
            value = selectedItem, onValueChange = {},
            trailingIcon = {ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedState)},
            readOnly = true)

        ExposedDropdownMenu(expanded = expandedState,
        onDismissRequest = { expandedState = false}) {
            stringList.forEach { item ->
                DropdownMenuItem(text = { }, onClick = {
                    selectedItem = item
                    expandedState = false
                    Toast.makeText(mContext, "" + selectedItem, Toast.LENGTH_LONG).show()
                })
            }
        }
    }
}