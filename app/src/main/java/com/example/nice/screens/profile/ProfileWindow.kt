package com.example.nice.screens.profile

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.nice.R
import com.example.nice.assistants.GetLocalClient
import com.example.nice.assistants.GetLocalSpecialist
import com.example.nice.templates.ClientDataResponse
import com.example.nice.templates.SpecialistDataResponse
import java.time.LocalDate
import java.util.Calendar


@Composable
fun ProfileWindow(navController: NavHostController, role: String){
    var selectedRole = role
    if(selectedRole == "Client"){
        ClientProfile()
    }else if(selectedRole == "Specialist"){
        SpecialistProfile()
    }
}
@Composable
fun ClientProfile(){
    val client: ClientDataResponse? = GetLocalClient()
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

            ShowClient(client!!.login, client!!.username, client!!.birthdate)
            ClientCard()
            ExitButtonComponent()
        }
    }
}

@Composable
fun SpecialistProfile(){
    val specialist: SpecialistDataResponse? = GetLocalSpecialist()
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
            Image(painter = painterResource(id = R.drawable.specialist_pic), contentDescription = null,
                modifier = Modifier.size(150.dp))
           ShowSpecialist(specialist!!.login, specialist!!.username, specialist!!.usersurname, specialist!!.birthdate)

            //CardComponent(specialist.id)

            ExitButtonComponent()
        }
    }
}



@Composable
fun ShowSpecialist(login: String?, name: String?, surname: String?, stringDate: String?){
    val birthDate = LocalDate.parse(stringDate)
    val currentDate = LocalDate.now()
    val age = currentDate.year - birthDate.year
    val ageDigit = age % 10
    val ageText = when {
        ageDigit == 1 -> "$age год"
        ageDigit in 2..4 -> "$age года"
        else -> "$age лет"
    }

    Text(
        modifier = Modifier.padding(top = 15.dp),
        color = colorResource(id = R.color.purple),
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp,
        text = "@$login"
    )
    Text(
        color = colorResource(id = R.color.purple),
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        text = "$name $surname, $ageText"
    )
}

@Composable
fun ShowClient(login: String?, name: String?, stringDate: String?){
    val birthDate = LocalDate.parse(stringDate)
    val currentDate = LocalDate.now()
    val age = currentDate.year - birthDate.year
    val ageDigit = age % 10
    val ageText = when {
        ageDigit == 1 -> "$age год"
        ageDigit in 2..4 -> "$age года"
        else -> "$age лет"
    }

    Text(
        modifier = Modifier.padding(top = 15.dp),
        color = colorResource(id = R.color.purple),
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp,
        text = "@$login"
    )
    Text(
        color = colorResource(id = R.color.purple),
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        text = "$name, $ageText"
    )
}
@Composable
fun ClientCard(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 18.dp)
        .horizontalScroll(rememberScrollState())
    ) {
        Image(painter = painterResource(id = R.drawable.panel_1), contentDescription = null,
            modifier = Modifier
                .height(250.dp)
                .padding(start = 15.dp))
        Image(painter = painterResource(id = R.drawable.panel_2), contentDescription = null,
            modifier = Modifier
                .height(250.dp)
                .padding(start = 15.dp))
        Image(painter = painterResource(id = R.drawable.panel_3), contentDescription = null,
            modifier = Modifier
                .height(250.dp)
                .padding(start = 15.dp))
        Image(painter = painterResource(id = R.drawable.panel_4), contentDescription = null,
            modifier = Modifier
                .height(250.dp)
                .padding(start = 15.dp))
        Image(painter = painterResource(id = R.drawable.panel_5), contentDescription = null,
            modifier = Modifier
                .height(250.dp)
                .padding(start = 15.dp, end = 15.dp))
    }
}
@Composable
fun CardComponent(id: Int){
    val viewModel: ProfileViewModel = viewModel()
    val points = viewModel.SpecialistPoints(id)
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp, 20.dp, 20.dp, 0.dp),
        elevation = CardDefaults.cardElevation(5.dp),
        shape = RoundedCornerShape(25.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.siren))
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(text = "Образование:", fontSize = 17.sp, fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.white))
            Text(text = "Дополнительное образование:", fontSize = 17.sp, fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.white))
            Text(modifier = Modifier.padding(top = 20.dp),
                text = "Специалист работает со следующими темами:", fontSize = 17.sp, fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.white))
            LazyColumn {
                items(points){item ->
                    Text(text = item.id.toString())
                    Text(text = item.pointname.toString())
                }
            }
        }
    }
}
@Composable
fun ExitButtonComponent(){
    Button(onClick = {},
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.purple)),
        modifier = Modifier.padding(top = 25.dp),
        elevation = ButtonDefaults.buttonElevation(5.dp)) {
        Text(text = "Выйти", fontSize = 20.sp, color = colorResource(id = R.color.white))
    }
}

//НЕ ОТСЮДА
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerComponent(){
    val context: Context = LocalContext.current
    val datePickerState = rememberDatePickerState()
    var showDatePicker by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(top = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(color = colorResource(id = R.color.purple),
            fontWeight = FontWeight.Bold, fontSize = 20.sp,
            text = "Дата не выбрана")
        Button(onClick = {
                         showDatePicker = true
        },
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.purple)),
            elevation = ButtonDefaults.buttonElevation(5.dp)) {
            Text(text = "Выбрать дату", fontSize = 20.sp, color = colorResource(id = R.color.white))
        }
    }
    if(showDatePicker == true){
        DatePickerDialog(
            onDismissRequest = { /*TODO*/ },
            confirmButton = { TextButton(onClick = {
                val selectedDate = Calendar.getInstance().apply {
                    timeInMillis = datePickerState.selectedDateMillis!!
                }
                if (selectedDate.after(Calendar.getInstance())) {
                    Toast.makeText(context, "Selected date ${selectedDate.time} saved", Toast.LENGTH_SHORT).show()
                    showDatePicker = false
                } else {
                    Toast.makeText(context, "Selected date should be after today, please select again", Toast.LENGTH_SHORT).show()
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