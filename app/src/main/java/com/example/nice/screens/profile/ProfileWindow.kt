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
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.navigation.NavHostController
import com.example.nice.R
import com.example.nice.assistants.GetLocalClient
import com.example.nice.assistants.GetLocalSpecialist
import com.example.nice.screens.PointSample
import com.example.nice.templates.ClientDataResponse
import com.example.nice.templates.PointDataResponse
import com.example.nice.templates.SpecialistDataResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDate
import java.util.Calendar

@Composable
fun ProfileWindow(navController: NavHostController, role: String){
    var selectedRole = role
    val client: ClientDataResponse? = GetLocalClient()
    val specialist: SpecialistDataResponse? = GetLocalSpecialist()
    val viewModel = ProfileViewModel()

    var points by remember { mutableStateOf<List<PointDataResponse>>(emptyList()) }

    GlobalScope.launch {
        specialist?.let {
            withContext(Dispatchers.IO) {
                val pointsList = viewModel.SpecialistPoints(it.id!!.toInt())
                points = pointsList
            }
        }
    }

    if(selectedRole == "Client"){
        ClientProfile(client)
    }else if(selectedRole == "Specialist"){
        SpecialistProfileWithMenu(points = points, specialist = specialist)
    }
}
@Composable
fun ClientProfile(client:ClientDataResponse?){
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
fun SpecialistProfileWithMenu(points: List<PointDataResponse>, specialist: SpecialistDataResponse?) {
    val menuState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = menuState,
        drawerContent = {
            MenuComponent(scope, menuState)
        },
        content = {
            SpecialistProfile(points, specialist)
        }
    )
}

@Composable
fun SpecialistProfile(points: List<PointDataResponse>, specialist: SpecialistDataResponse?) {
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
            CardComponent(points)
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
        Image(painter = painterResource(id = R.drawable.end_panel), contentDescription = null,
            modifier = Modifier
                .height(250.dp)
                .padding(start = 15.dp, end = 15.dp))
    }
}
@Composable
fun CardComponent(list: List<PointDataResponse>) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(450.dp)
            .padding(20.dp, 20.dp, 20.dp, 0.dp),
        elevation = CardDefaults.cardElevation(5.dp),
        shape = RoundedCornerShape(25.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.siren))
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = "Образование:",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.white)
            )
            Text(
                text = "Дополнительное образование:",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.white)
            )
            Text(
                modifier = Modifier.padding(top = 20.dp),
                text = "Специалист работает со следующими темами:",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.white)
            )
            LazyColumn() {
                items(list) { item ->
                    PointSample(content = item.pointname.toString())
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
