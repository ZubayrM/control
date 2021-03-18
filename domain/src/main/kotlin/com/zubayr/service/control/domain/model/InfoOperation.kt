package com.zubayr.service.control.domain.model

import com.zubayr.service.control.domain.model.Enum.StageStatusEnum
import javax.persistence.*

@Entity
@Table(name = "info_operation")
data class InfoOperation(

        @ManyToOne
    @JoinColumn(name = "operation_id")
    var operation: Operation? = null,

        @Enumerated(EnumType.ORDINAL)
    @Column(name = "stage")
    var stage: StageStatusEnum? = StageStatusEnum.NOT_DONE,

        @ManyToOne
    @JoinColumn(name = "employee_id")
    var employee: Employee? = null,

        @ManyToOne
    @JoinColumn(name = "detail_id")
    var detail: Detail? = null

) : BaseEntity()