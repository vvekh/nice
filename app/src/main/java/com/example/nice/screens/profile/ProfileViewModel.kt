package com.example.nice.screens.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.nice.retrofit.ClientAPI
import com.example.nice.retrofit.InterfaceAPI
import com.example.nice.templates.PointDataResponse
import retrofit2.Call

class ProfileViewModel : ViewModel() {
    fun SpecialistPoints(id: Int): List<PointDataResponse> {
        val api = ClientAPI.start()?.create(InterfaceAPI::class.java)
        val call: Call<List<PointDataResponse>>? = api?.SpecialistPoints(id)
        val response = call?.execute()
        return if (response?.isSuccessful == true) {
            response.body() ?: emptyList()
        } else {
            Log.d("BAD RESPONSE", "Ошибка при получении данных: ${response?.code()}")
            emptyList()
        }
    }
}