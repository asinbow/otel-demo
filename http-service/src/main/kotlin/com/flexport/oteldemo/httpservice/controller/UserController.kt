package com.flexport.oteldemo.httpservice.controller

import com.flexport.oteldemo.api.AddressApiGrpcKt.AddressApiCoroutineStub
import com.flexport.oteldemo.api.GetAddressesRequest
import com.flexport.oteldemo.api.UserApiGrpcKt.UserApiCoroutineStub
import com.flexport.oteldemo.api.UserRequest
import com.flexport.oteldemo.httpservice.dto.AddressDto
import com.flexport.oteldemo.httpservice.dto.UserDto
import io.opentelemetry.extension.annotations.SpanAttribute
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import io.opentelemetry.extension.annotations.WithSpan

@RestController
@RequestMapping(value = ["/user"])
class UserController(
    private val userApi: UserApiCoroutineStub,
    private val addressApi: AddressApiCoroutineStub,
) {
    @GetMapping(value = ["/{id}"])
    suspend fun getUser(@PathVariable("id") id: String): UserDto {
        val user = userApi.getUser(
            UserRequest.newBuilder().setId(id).build()
        ).user
        return UserDto(
            id = user.id,
            name = user.name,
            age = user.age,
            addresses = getAddresses(id)
        )
    }

    @WithSpan
    private suspend fun getAddresses(@SpanAttribute userId: String): List<AddressDto> {
        val addresses = addressApi.getAddresses(
            GetAddressesRequest.newBuilder().setUserId(userId).build()
        ).addressesList

        return addresses.map { AddressDto(id = it.id, city = it.city) }
    }
}
