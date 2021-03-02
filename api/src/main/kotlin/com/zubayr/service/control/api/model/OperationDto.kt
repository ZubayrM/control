package com.zubayr.service.control.api.model

import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

data class OperationDto (
        val name: String? = null,
        val serialNumber: Int? = null,
        val serialNumberByOperation: Int? = null,
        val detail: UUID? = null,
        val time_in_hours: BigDecimal? = null
)