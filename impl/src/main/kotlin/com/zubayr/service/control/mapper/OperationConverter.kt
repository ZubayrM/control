package com.zubayr.service.control.mapper

import com.zubayr.service.control.api.model.OperationDto
import com.zubayr.service.control.domain.model.Operation
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

//@Mapper
interface OperationConverter {
    @Mappings(
            Mapping(source = "name", target = "name"),
            Mapping(source = "serialNumber", target = "serialNumber"),
            Mapping(source = "serialNumberByOperation", target = "serialNumberByOperation"),
            Mapping(source = "detail", target = "detail"),
            Mapping(source = "time_in_hours", target = "time_in_hours")
    )
    fun convertToDto(operation: Operation): OperationDto


    @Mappings(
            Mapping(source = "name", target = "name"),
            Mapping(source = "serialNumber", target = "serialNumber"),
            Mapping(source = "serialNumberByOperation", target = "serialNumberByOperation"),
            Mapping(source = "detail", target = "detail"),
            Mapping(source = "time_in_hours", target = "time_in_hours")
    )
    fun convertToModel(dto: OperationDto): Operation
}