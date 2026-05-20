package com.sam.domain.model

data class UserProfile(
    val id: String,
    val name: String,
    val homeLocation: Location?,
    val workLocation: Location?
)

data class Location(
    val latitude: Double,
    val longitude: Double
)
