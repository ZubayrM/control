package com.zubayr.service.control.domain.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "product")
data class Product (

        @Id
        @GeneratedValue(generator = "uuid")
        val id: UUID? = null,

        @Column(name = "name")
        val name: String? = null,

        @Column(name = "cipher")
        val cipher: String? = null
)