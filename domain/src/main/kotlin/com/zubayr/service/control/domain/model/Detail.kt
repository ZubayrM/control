package com.zubayr.service.control.domain.model

import java.math.BigDecimal
import java.util.*
import javax.persistence.*
import kotlin.collections.ArrayList

@Entity
@Table(name = "detail")
data class Detail (

        @Id
        @GeneratedValue(generator = "uuid")
        val id: UUID? = null,

        @Column(name = "name")
        val name: String? = null,

        @Column(name = "cipher")
        val cipher: String? = null,

        @ManyToOne
        @JoinColumn (name = "product_id")
        val product: Product? = null,

        @Column(name = "route")
        val route: String? = null,

        @Column(name = "material")
        val material: String? = null,

        @Column(name = "full_time_created")
        val fullTimeCreated: BigDecimal? = null,

        @OneToMany
        val operations: List<InfoOperation>? = ArrayList(),

        @ManyToOne
        @JoinColumn(name ="plan_id")
        val plan: Plan? = null

)