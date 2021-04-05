package com.zubayr.service.control.api.model

import java.math.BigDecimal

data class OperationDto(
        var name: String? = null,
        var serialNumber: Int? = null,
        var serialNumberByOperation: Int? = null,
        var cipherDetail: String? = null,
        var time_in_hours: BigDecimal? = null,
        var employees: Set<EmployeeDto>? = null
) : BaseDto()