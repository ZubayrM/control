package com.zubayr.service.control.api.model

import com.zubayr.service.control.domain.model.Enum.ProfessionEnum

data class EmployeeDto(
        var name: String? = null,
        var surname: String? = null,
        var dataOfBirth: String? = null,
        var professionEnum: ProfessionEnum? = null
) : BaseDto()