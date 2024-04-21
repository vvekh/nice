package com.example.nice.models

data class Note(
    val id: Int,
    val title: String,
    val content: String,
    val specialistid: Int,
    val status: String
)