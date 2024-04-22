package com.example.nice.retrofit

import com.example.nice.templates.ClientDataResponse
import com.example.nice.templates.PointDataResponse
import com.example.nice.templates.SpecialistDataResponse
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
    ): Call<ClientDataResponse>

    @Headers("Accept: application/json")
    @GET("Specialist/{login}&{password}")
    fun SpecialistAuthorize(
        @Path("login") login: String?,
        @Path("password") password: String?
    ): Call<SpecialistDataResponse>

    @Headers("Accept: application/json")
    @GET("Specialist/{id}/Points")
    fun SpecialistPoints(@Path("id") id: Int): Call<List<PointDataResponse>>
}