package com.sam.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sam.domain.model.UserProfile
import com.sam.domain.model.Location

@Entity(tableName = "user_profile")
data class UserProfileEntity(
    @PrimaryKey val id: String,
    val name: String,
    val homeLatitude: Double?,
    val homeLongitude: Double?,
    val workLatitude: Double?,
    val workLongitude: Double?
)

fun UserProfileEntity.toDomain() = UserProfile(
    id = id,
    name = name,
    homeLocation = if (homeLatitude != null && homeLongitude != null) Location(homeLatitude, homeLongitude) else null,
    workLocation = if (workLatitude != null && workLongitude != null) Location(workLatitude, workLongitude) else null
)

fun UserProfile.toEntity() = UserProfileEntity(
    id = id,
    name = name,
    homeLatitude = homeLocation?.latitude,
    homeLongitude = homeLocation?.longitude,
    workLatitude = workLocation?.latitude,
    workLongitude = workLocation?.longitude
)
