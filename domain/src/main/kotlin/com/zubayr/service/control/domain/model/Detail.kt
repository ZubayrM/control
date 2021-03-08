package com.zubayr.service.control.domain.model

import java.math.BigDecimal
import java.util.*
import javax.persistence.*
import kotlin.collections.ArrayList

@Entity
@Table(name = "detail")
data class Detail (

        @Column(name = "name")
        var name: String? = null,

        @Column(name = "cipher")
        var cipher: String? = null,

        @Column(name = "product_id")
        var productId: UUID? = null,

        @Column(name = "route")
        var route: String? = null,

        @Column(name = "material")
        var material: String? = null,

        @Column(name = "full_time_created")
        var fullTimeCreated: BigDecimal? = null,

        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "detail", fetch = FetchType.LAZY)
        var infoOperations: List<InfoOperation>? = null

) : BaseEntity()