package com.example.nice.screens.sign

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.nice.assistants.SetLocalCLient
import com.example.nice.assistants.SetLocalSpecialist
import com.example.nice.navigation.Screen
import com.example.nice.retrofit.ClientAPI
import com.example.nice.retrofit.InterfaceAPI
import com.example.nice.templates.ClientDataResponse
import com.example.nice.templates.SpecialistDataResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignViewModel : ViewModel() {
    //Переменные модели
    var userLogin by mutableStateOf("")
        private set
    var userPassword by mutableStateOf("")
        private set

    //Методы, обновляющие переменные
    fun UserLoginUpdate(login: String){
        userLogin = login
    }
    fun UserPasswordUpdate(password: String){
        userPassword = password
    }

    //Метод авторизации, который использует переменные модели и методы записи локальных данных по шаблонам
    fun Authorization(navController: NavHostController, role: String) {
        var selectedRole = role
        val api = ClientAPI.start()?.create(InterfaceAPI::class.java)
        if(selectedRole == "Client"){
            val call: Call<ClientDataResponse>? = api?.ClientAuthorize(userLogin, userPassword)
            call!!.enqueue(object : Callback<ClientDataResponse> {
                override fun onResponse(call: Call<ClientDataResponse>, response: Response<ClientDataResponse>) {

                    Log.d("SUCCESS", response.body().toString())

                    val responseClient = response.body()
                    if (responseClient != null) {
                        SetLocalCLient(responseClient)
                        navController.navigate(Screen.ProfileWindow.selectedRole(selectedRole))
                    }

                }override fun onFailure(call: Call<ClientDataResponse>, t: Throwable) {
                    Log.d("BAD RESPONSE", java.lang.String.valueOf(t.toString()))
                }
            })
        }else if(selectedRole == "Specialist"){
            val call: Call<SpecialistDataResponse>? = api?.SpecialistAuthorize(userLogin, userPassword)
            call!!.enqueue(object : Callback<SpecialistDataResponse> {
                override fun onResponse(call: Call<SpecialistDataResponse>, response: Response<SpecialistDataResponse>) {

                    Log.d("SUCCESS", java.lang.String.valueOf(response.toString()))

                    val responseSpecialist = response.body()
                    if (responseSpecialist != null) {
                        SetLocalSpecialist(responseSpecialist)
                        navController.navigate(Screen.ProfileWindow.selectedRole(selectedRole))
                    }

                }override fun onFailure(call: Call<SpecialistDataResponse>, t: Throwable) {
                    Log.d("BAD RESPONSE", java.lang.String.valueOf(t.toString()))
                }
            })
        }
    }

}
