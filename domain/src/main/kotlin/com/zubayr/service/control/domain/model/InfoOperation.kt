package com.zubayr.service.control.domain.model

import com.zubayr.service.control.domain.model.Enum.StageOfOperationEnum
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "info_operation")
data class InfoOperation(

    @Id
    @GeneratedValue(generator = "uuid")
    val id: UUID? = null,

    @ManyToOne
    @JoinColumn(name = "operation_id")
    val operation: Operation? = null,

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "stage")
    val stage: StageOfOperationEnum? = StageOfOperationEnum.NOT_DONE,

    @ManyToOne
    @JoinColumn(name = "employee_id")
    val employee: Employee? = null
)