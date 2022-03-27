package com.flexport.oteldemo.httpservice.dto

class UserDto(
    val id: String?,
    val name: String,
    val age: Int,
    val addresses: List<AddressDto>
)
