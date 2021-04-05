package com.zubayr.service.control.mapper

import com.zubayr.service.control.api.model.OperationDto
import com.zubayr.service.control.domain.model.Operation
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import org.mapstruct.ReportingPolicy

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
abstract class OperationMapper : BaseMapper<Operation, OperationDto>{

    abstract override fun convertToDto(entity: Operation): OperationDto

    abstract override fun convertToEntity(dto: OperationDto): Operation
}