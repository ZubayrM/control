package com.zubayr.service.control.api.model

import java.io.Serializable
import java.util.*

/**
 * DetailsStatusDto
 *
 * @author Denis_Kholmogorov
 */
data class DetailsStatusDto (
        var completeDetails: Long? = null,
        var notDoneDetails: Long? = null
)