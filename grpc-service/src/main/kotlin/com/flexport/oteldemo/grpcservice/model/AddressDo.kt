package com.flexport.oteldemo.grpcservice.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "addresses")
class AddressDo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: String? = null,

    var userId: String = "",

    var city: String = ""
)
