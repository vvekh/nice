package com.example.nice.screens.sign

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.nice.models.ClientDataResponse
import com.example.nice.retrofit.ClientAPI
import com.example.nice.retrofit.InterfaceAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignViewModel : ViewModel() {
    var clientLogin by mutableStateOf("")
        private set
    var clientPassword by mutableStateOf("")
        private set

    fun ClientLoginUpdate(login: String){
        clientLogin = login
    }
    fun ClientPasswordUpdate(password: String){
        clientPassword = password
    }

    fun LoadClientData(){
        val client = GetLocalClient()
    }

    fun Authorization(navController: NavHostController) {
        val api = ClientAPI.start()?.create(InterfaceAPI::class.java)
        val call: Call<ClientDataResponse>? = api?.ClientAuthorize(clientLogin, clientPassword)
        call!!.enqueue(object : Callback<ClientDataResponse> {
            override fun onResponse(call: Call<ClientDataResponse>, response: Response<ClientDataResponse>) {

                Log.d("SUCCESS", java.lang.String.valueOf(response.toString()))

                val responseClient = response.body()
                if (responseClient != null) {
                    SetLocalCLient(responseClient)
                }

            }override fun onFailure(call: Call<ClientDataResponse>, t: Throwable) {
                Log.d("BAD RESPONSE", java.lang.String.valueOf(t.toString()))
            }
        })
    }
}

private var client: ClientDataResponse? = null
fun SetLocalCLient(newClient: ClientDataResponse){
    client = ClientDataResponse(
        newClient.id,
        newClient.username,
        newClient.login,
        newClient.password,
        newClient.birthdate,
        newClient.timelineid
    )
}
fun GetLocalClient(): ClientDataResponse?{
    return client
}