package com.flexport.oteldemo.httpservice.controller

import com.flexport.oteldemo.api.AddressApiGrpcKt.AddressApiCoroutineStub
import com.flexport.oteldemo.api.GetAddressesRequest
import com.flexport.oteldemo.api.UserApiGrpcKt.UserApiCoroutineStub
import com.flexport.oteldemo.api.UserRequest
import com.flexport.oteldemo.httpservice.dto.AddressDto
import com.flexport.oteldemo.httpservice.dto.UserDto
import io.opentelemetry.api.common.AttributeKey
import io.opentelemetry.api.common.Attributes
import io.opentelemetry.api.metrics.Meter
import io.opentelemetry.api.trace.Span
import io.opentelemetry.extension.annotations.SpanAttribute
import io.opentelemetry.extension.annotations.WithSpan
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/user"])
class UserController(
    private val userApi: UserApiCoroutineStub,
    private val addressApi: AddressApiCoroutineStub,
    private val meter: Meter,
) {
    private val logger = KotlinLogging.logger {}

    @GetMapping(value = ["/{id}"])
    suspend fun getUser(@PathVariable("id") id: String): UserDto {
        val span = Span.current()
        span.setAttribute("id", id)
        span.addEvent("getUser", Attributes.of(AttributeKey.stringKey("id"), id))

        val user = userApi.getUser(
            UserRequest.newBuilder().setId(id).build()
        ).user

        logger.info { "get user $user" }
        meter.counterBuilder("getUser").build().add(1)
        span.addEvent("getAddresses")

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

        logger.info { "get addresses $addresses for $userId" }
        return addresses.map { AddressDto(id = it.id, city = it.city) }
    }
}
