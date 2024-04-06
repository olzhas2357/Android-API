package com.example.lab2.model

import com.google.gson.annotations.SerializedName

data class Info(
    val born: String,
    val died: String,
    @SerializedName("birth_name") val birthName: String,
    @SerializedName("years_active") val yearsActive: String,
    val instruments: String,
    val website: String
)
