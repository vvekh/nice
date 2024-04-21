package com.example.nice.screens.sign

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.nice.models.Client
import com.example.nice.retrofit.ClientAPI
import com.example.nice.retrofit.InterfaceAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignViewModel : ViewModel() {




    fun Authorization(login: String, password: String, onSuccess: (Client) -> Unit) {
        val api = ClientAPI.start()?.create(InterfaceAPI::class.java)
        val call: Call<Client>? = api?.ClientAuthorize(login, password)
        call!!.enqueue(object : Callback<Client?> {
            override fun onResponse(call: Call<Client?>, response: Response<Client?>) {
                if (response.isSuccessful) {
                    val client = response.body()
                    if (client != null) {
                        onSuccess(client)
                    }
                }
            }
            override fun onFailure(call: Call<Client?>, t: Throwable) {
                Log.d("FAILURE", t.toString())
            }
        })
    }
}