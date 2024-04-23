package com.example.nice.screens.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.nice.retrofit.ClientAPI
import com.example.nice.retrofit.InterfaceAPI
import com.example.nice.templates.PointDataResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call

class ProfileViewModel : ViewModel() {


    suspend fun SpecialistPoints(id: Int): List<PointDataResponse> {
        return withContext(Dispatchers.IO) {
            val api = ClientAPI.start()?.create(InterfaceAPI::class.java)
            val call: Call<List<PointDataResponse>>? = api?.SpecialistPoints(id)
            val response = call?.execute()
            if (response?.isSuccessful == true) {
                response.body() ?: emptyList()
            } else {
                Log.d("BAD RESPONSE", "Error while fetching data: ${response?.code()}")
                emptyList()
            }
        }
    }
}