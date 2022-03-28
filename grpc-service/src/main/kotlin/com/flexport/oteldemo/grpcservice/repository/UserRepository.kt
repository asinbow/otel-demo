package com.flexport.oteldemo.grpcservice.repository

import com.flexport.oteldemo.grpcservice.model.UserDo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UserDo, String>
