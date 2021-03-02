package com.zubayr.service.control.mapper

import com.zubayr.service.control.api.model.PlanDto
import com.zubayr.service.control.domain.model.Plan
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

//@Mapper
interface PlanConverter {

    @Mappings(
            Mapping(source = "id", target = "id"),
            Mapping(dateFormat = "dd.MM.yyyy", target = "startDate"),
            Mapping(dateFormat = "dd.MM.yyyy", target = "endDate"),
            Mapping(dateFormat = "dd.MM.yyyy", target = "realEndDate")
    )
    fun convertToDto(plan: Plan): PlanDto


    @Mappings(
            Mapping(source = "id", target = "id"),
            Mapping(source = "startDate", target = "startDate"),
            Mapping(source = "endDate", target = "endDate"),
            Mapping(source = "realEndDate", target = "realEndDate")
    )
    fun convertToModel(dto: PlanDto): Plan
}