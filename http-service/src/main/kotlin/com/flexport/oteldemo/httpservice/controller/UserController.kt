package com.flexport.oteldemo.httpservice.controller

import com.flexport.oteldemo.httpservice.dto.AddressDto
import com.flexport.oteldemo.httpservice.dto.UserDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/user"])
class UserController {
    @GetMapping(value = ["/{id}"])
    fun getUser(@PathVariable("id") id: String): UserDto {
        return UserDto(
            id = id,
            name = "foo",
            age = 20,
            addresses = listOf(
                AddressDto(id = "1", city = "Shenzhen"),
                AddressDto(id = "2", city = "Shanghai"),
            )
        )
    }
}
