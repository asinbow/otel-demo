package com.flexport.oteldemo.grpcservice.api

import com.flexport.oteldemo.api.Address
import com.flexport.oteldemo.api.AddressApiGrpcKt.AddressApiCoroutineImplBase
import com.flexport.oteldemo.api.GetAddressesRequest
import com.flexport.oteldemo.api.GetAddressesResponse
import com.flexport.oteldemo.grpcservice.model.AddressDo
import com.flexport.oteldemo.grpcservice.repository.AddressRepository
import org.lognet.springboot.grpc.GRpcService

@GRpcService
class AddressApi(
    private val addressRepository: AddressRepository
) : AddressApiCoroutineImplBase() {
    override suspend fun getAddresses(request: GetAddressesRequest): GetAddressesResponse {
        val addresses = listOf(
            AddressDo(city = "Shenzhen"),
            AddressDo(city = "Shanghai")
        )
        addressRepository.saveAll(addresses)

        return GetAddressesResponse
            .newBuilder()
            .addAllAddresses(
                addresses.map {
                    Address
                        .newBuilder()
                        .setId("${it.id} by ${request.userId}")
                        .setCity(it.city)
                        .build()
                }
            ).build()
    }
}
