package com.flexport.oteldemo.grpcservice.repository

import com.flexport.oteldemo.grpcservice.model.AddressDo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AddressRepository : JpaRepository<AddressDo, String>
