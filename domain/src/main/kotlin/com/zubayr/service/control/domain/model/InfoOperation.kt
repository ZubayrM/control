package com.zubayr.service.control.domain.model

import com.zubayr.service.control.domain.model.Enum.StageStatusEnum
import java.time.ZonedDateTime
import javax.persistence.*

@Entity
@Table(name = "info_operation")
data class InfoOperation(

        @Column(name = "start_time")
        var startTime: ZonedDateTime? = null,

        @Column(name = "end_time")
        var endTime: ZonedDateTime? = null,

        @Enumerated(EnumType.ORDINAL)
        @Column(name = "stage")
        var stage: StageStatusEnum? = StageStatusEnum.NOT_DONE,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "operation_id")
        var operation: Operation? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "employee_id")
        var employee: Employee? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "detail_id")
        var detail: Detail? = null

) : BaseEntity()