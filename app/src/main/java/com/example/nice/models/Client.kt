package com.example.nice.models

data class ClientData (
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
