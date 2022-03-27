package com.flexport.oteldemo.httpservice.configuration

import com.flexport.oteldemo.api.AddressApiGrpcKt.AddressApiCoroutineStub
import com.flexport.oteldemo.api.UserApiGrpcKt.UserApiCoroutineStub
import io.grpc.Channel
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GrpcConfiguration {

    @Bean(destroyMethod = "shutdown")
    fun apiChannel(
        @Value("\${service.api.host}") host: String,
        @Value("\${service.api.port}") port: Int
    ): ManagedChannel {
        return ManagedChannelBuilder.forAddress(host, port)
            .usePlaintext()
            .build()
    }

    @Bean
    fun userApi(apiChannel: Channel): UserApiCoroutineStub {
        return UserApiCoroutineStub(apiChannel)
    }

    @Bean
    fun addressApi(apiChannel: Channel): AddressApiCoroutineStub {
        return AddressApiCoroutineStub(apiChannel)
    }
}
