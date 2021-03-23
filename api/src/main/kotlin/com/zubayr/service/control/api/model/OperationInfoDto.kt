package com.zubayr.service.control.api.model

import java.math.BigDecimal
import java.util.*

data class OperationInfoDto(
        var name: String? = null,
        var serialNumber: Int? = null,
        var serialNumberByOperation: Int? = null,
        var cipherDetail: UUID? = null,
        var time_in_hours: BigDecimal? = null
) : BaseDto()