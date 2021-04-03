package com.zubayr.service.control.api.model

import java.util.*
import kotlin.collections.HashMap

/**
 * SetupOperationDto
 *
 * @author Denis_Kholmogorov
 */
data class SetupOperationDto(
        var detailCipher: String,
        var countDetails: Int,
        var productId: UUID,
        var employeeId: UUID,
        var operationId: UUID
)