package com.zubayr.service.control.domain.model

import com.zubayr.service.control.domain.model.Enum.StageStatusEnum
import java.math.BigDecimal
import java.time.ZonedDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "detail")
data class Detail (

        @Column(name = "name")
        var name: String? = null,

        @Column(name = "cipher")
        var cipher: String? = null,

        @Column(name = "product_id")
        var productId: UUID? = null,

        @Column(name = "start_time")
        var startTime: ZonedDateTime? = null,

        @Column(name = "end_time")
        var endTime: ZonedDateTime? = null,

        @Column(name = "real_end_date")
        var realEndTime: ZonedDateTime?= null,

        @Column(name = "route")
        var route: String? = null,

        @Column(name = "material")
        var material: String? = null,

        @Column(name = "full_time_created")
        var fullTimeCreated: BigDecimal? = null,

        @Enumerated(EnumType.ORDINAL)
        @Column(name = "stage")
        var stage: StageStatusEnum? = StageStatusEnum.NOT_DONE,

        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "detail")
        var infoOperations: MutableList<InfoOperation>? = mutableListOf()

) : BaseEntity()