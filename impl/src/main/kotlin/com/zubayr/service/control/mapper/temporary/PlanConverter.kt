package com.zubayr.service.control.mapper.temporary

import com.zubayr.service.control.api.model.PlanDto
import com.zubayr.service.control.domain.model.Plan

class PlanConverter: Converter<Plan, PlanDto> {
    override fun toModel(dto: PlanDto): Plan {
        TODO("Not yet implemented")
    }

    override fun toDto(model: Plan): PlanDto {
        TODO("Not yet implemented")
    }
}