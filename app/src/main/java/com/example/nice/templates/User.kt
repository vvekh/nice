package com.example.nice.templates

//Шаблоны, по которым записываются и получаются данные
data class UserAuthorizeData (
    val login: String,
    val password: String
)
data class ClientDataResponse(
    var id: String?,
    var username: String?,
    var login: String?,
    var password: String?,
    var birthdate: String?,
    var timelineid: String?,
)
data class SpecialistDataResponse(
    val id: String?,
    val username: String?,
    val usersurname: String?,
    val birthdate: String?,
    val login: String?,
    val password: String?,
    val sexid: String?,
    val graduationid: String?,
    val graduatuon2: String?,
    val timelineid: String?,
    val price: String?,
    val status: String?
)
