package com.zubayr.service.control.mapper

import com.zubayr.service.control.api.model.OperationInfoDto
import com.zubayr.service.control.domain.model.Operation
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import org.mapstruct.ReportingPolicy

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
abstract class OperationMapper : BaseMapper<Operation, OperationInfoDto>{

    @Mappings(
            Mapping(target = "id", ignore = true)
    )
    abstract override fun convertToDto(entity: Operation): OperationInfoDto

    abstract override fun convertToEntity(infoDto: OperationInfoDto): Operation
}