package com.example.fasefinalproject.data.remote

data class RandomUserResponse(
    val results: List<UserDto>
)

data class UserDto(
    val name: NameDto,
    val location: LocationDto,
    val picture: PictureDto
)

data class NameDto(
    val first: String,
    val last: String
)

data class LocationDto(
    val city: String
)

data class PictureDto(
    val medium: String
)
