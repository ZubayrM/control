package com.zubayr.service.control.api.model

import java.util.*

data class PlanDto (
        val id: UUID? = null,
        val startDate: String? = null,
        val endDate: String? = null,
        val realEndDate: String? = null

)