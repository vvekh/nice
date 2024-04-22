package com.example.nice.assistants

import com.example.nice.templates.ClientDataResponse
import com.example.nice.templates.PointDataResponse
import com.example.nice.templates.SpecialistDataResponse

//Методы записи и получения локального юзера по шаблонам (в зависимости от роли)
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
//

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
//

private var point: PointDataResponse? = null
fun SetLocalPoint(newPoint: PointDataResponse){
    point = PointDataResponse(
        newPoint.id,
        newPoint.pointname
    )
}
fun GetLocalPoint(): PointDataResponse?{
    return point
}

fun SetLocalPointList(list: List<PointDataResponse>){

}