package com.example.nice.models

data class SpecialistData (
    val login: String,
    val password: String
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
