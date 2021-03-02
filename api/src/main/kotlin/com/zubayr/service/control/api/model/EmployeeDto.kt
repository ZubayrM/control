package com.zubayr.service.control.api.model

import com.zubayr.service.control.domain.model.Enum.ProfessionEnum
import java.util.*

data class EmployeeDto (
        val id: UUID? = null,
        val name: String? = null,
        val surname: String? = null,
        val dataOfBirth: String? = null,
        val professionEnum: ProfessionEnum? = null
)