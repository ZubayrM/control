package com.zubayr.service.control.domain.model

import com.zubayr.service.control.domain.model.Enum.StageOfOperation
import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "operation")
class Operation (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: UUID,

        @Column(name = "name")
        val name: String,

        @Column(name = "serial_number")
        val serialNumber: Int,

        @Column(name = "serial_number_by_operation")
        val serialNumberByOperation: Int,

        @ManyToOne
        @JoinColumn(name = "detail_id")
        val detail: Detail,

        @Column(name = "time_in_hours")
        val time_in_hours: LocalDate,

        @ManyToOne
        @JoinColumn(name = "employee_id")
        val employee: Employee,

        @Column(name = "stage")
        val stage: StageOfOperation






)