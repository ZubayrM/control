package com.zubayr.service.control.domain.model

import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "operation")
data class Operation (
        @Id
        @GeneratedValue(generator = "uuid")
        val id: UUID? = null,

        @Column(name = "name")
        val name: String? = null,

        @Column(name = "serial_number")
        val serialNumber: Int? = null,

        @Column(name = "serial_number_by_operation")
        val serialNumberByOperation: Int? = null,

        @Column(name = "cipher_of_detail")
        val detail: String? = null,

        @Column(name = "time_in_hours")
        val time_in_hours: BigDecimal? = null
)