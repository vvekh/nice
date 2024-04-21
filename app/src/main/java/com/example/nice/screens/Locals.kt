package com.example.nice.screens

import com.example.nice.models.ClientDataResponse
import com.example.nice.models.SpecialistDataResponse

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

private var specialist: SpecialistDataResponse? = null
fun SetLocalSpecialist(newSpecialist: SpecialistDataResponse){
    specialist = SpecialistDataResponse(
        newSpecialist.id,
        newSpecialist.username,
        newSpecialist.usersurname,
        newSpecialist.birthdate,
        newSpecialist.login,
        newSpecialist.password,
        newSpecialist.sexid,
        newSpecialist.graduationid,
        newSpecialist.graduatuon2,
        newSpecialist.timelineid,
        newSpecialist.price,
        newSpecialist.status
    )
}
fun GetLocalSpecialist(): SpecialistDataResponse?{
    return specialist
}