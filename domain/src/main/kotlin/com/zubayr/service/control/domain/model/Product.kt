package com.zubayr.service.control.domain.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "product")
data class Product (

        @Column(name = "name")
        var name: String? = null,

        @Column(name = "cipher")
        var cipher: String? = null,

        @ManyToOne
        @JoinColumn(name ="plan_id")
        val plan: Plan? = null

) : BaseEntity()