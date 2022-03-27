package com.flexport.oteldemo.grpcservice.api

import com.flexport.oteldemo.api.User
import com.flexport.oteldemo.api.UserApiGrpcKt.UserApiCoroutineImplBase
import com.flexport.oteldemo.api.UserRequest
import com.flexport.oteldemo.api.UserResponse
import org.lognet.springboot.grpc.GRpcService

@GRpcService
class UserApi : UserApiCoroutineImplBase() {
    override suspend fun getUser(request: UserRequest): UserResponse {
        return UserResponse
            .newBuilder()
            .setUser(
                User
                    .newBuilder()
                    .setId(request.id)
                    .setName("foo")
                    .setAge(20)
                    .build()
            ).build()
    }
}
