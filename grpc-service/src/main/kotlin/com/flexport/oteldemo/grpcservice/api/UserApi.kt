package com.flexport.oteldemo.grpcservice.api

import com.flexport.oteldemo.api.User
import com.flexport.oteldemo.api.UserApiGrpcKt.UserApiCoroutineImplBase
import com.flexport.oteldemo.api.UserRequest
import com.flexport.oteldemo.api.UserResponse
import com.flexport.oteldemo.grpcservice.model.UserDo
import com.flexport.oteldemo.grpcservice.repository.UserRepository
import org.lognet.springboot.grpc.GRpcService

@GRpcService
class UserApi(
    private val userRepository: UserRepository
) : UserApiCoroutineImplBase() {
    override suspend fun getUser(request: UserRequest): UserResponse {
        val user = UserDo(name = "foo", age = 20)
        userRepository.save(user)

        return UserResponse
            .newBuilder()
            .setUser(
                User
                    .newBuilder()
                    .setId("${request.id} -> ${user.id}")
                    .setName(user.name)
                    .setAge(user.age)
                    .build()
            ).build()
    }
}
