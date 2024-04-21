package com.example.nice.retrofit

import com.example.nice.models.Client
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface InterfaceAPI {
    @Headers("Accept: application/json")
    @GET("CLient/{login}&{password}")
    fun ClientAuthorize(
        @Path("login") login: String?,
        @Path("password") password: String?
    ): Call<Client>

}