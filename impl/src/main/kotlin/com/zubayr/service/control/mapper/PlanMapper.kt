package com.zubayr.service.control.mapper

import com.zubayr.service.control.api.model.PlanDto
import com.zubayr.service.control.domain.model.Plan
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
abstract class PlanMapper : BaseMapper<Plan,PlanDto>{

    abstract override fun convertToDto(entity: Plan): PlanDto

    abstract override fun convertToEntity(dto: PlanDto): Plan
}