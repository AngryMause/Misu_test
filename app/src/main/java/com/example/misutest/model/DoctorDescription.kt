package com.example.misutest.model

data class DoctorDescription(
    val avatar: Int?,
    val doctorName: String,
    val doctorSecondName: String,
    val doctorSpecialty: String,
    val cityOfWork: String,
    val list: List<DoctorWorkWith>,
    val workDescription: String,
)

data class DoctorWorkWith(
    val workWith: String,
)

