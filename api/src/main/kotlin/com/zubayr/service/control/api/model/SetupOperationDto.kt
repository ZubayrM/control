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
        var employeeWithOperation: HashMap<UUID,UUID>
)