package com.flexport.oteldemo.grpcservice.api

import com.flexport.oteldemo.api.Address
import com.flexport.oteldemo.api.AddressApiGrpcKt.AddressApiCoroutineImplBase
import com.flexport.oteldemo.api.GetAddressesRequest
import com.flexport.oteldemo.api.GetAddressesResponse
import org.lognet.springboot.grpc.GRpcService

@GRpcService
class AddressApi : AddressApiCoroutineImplBase() {
    override suspend fun getAddresses(request: GetAddressesRequest): GetAddressesResponse {
        return GetAddressesResponse
            .newBuilder()
            .addAllAddresses(
                listOf(
                    Address
                        .newBuilder()
                        .setId("1")
                        .setCity("Shenzhen")
                        .build(),
                    Address
                        .newBuilder()
                        .setId("2")
                        .setCity("Shanghai")
                        .build()
                )
            ).build()
    }
}
