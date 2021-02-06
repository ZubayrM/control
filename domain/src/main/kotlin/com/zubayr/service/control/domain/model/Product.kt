package com.zubayr.service.control.domain.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "product")
class Product (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: UUID,

        @Column(name = "name")
        val name: String,

        @Column(name = "description")
        val designation: String
)