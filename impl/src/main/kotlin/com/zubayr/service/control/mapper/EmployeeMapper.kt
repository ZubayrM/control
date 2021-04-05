package com.zubayr.service.control.mapper

import com.zubayr.service.control.api.model.EmployeeDto
import com.zubayr.service.control.domain.model.Employee
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import org.mapstruct.ReportingPolicy

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
abstract class EmployeeMapper : BaseMapper<Employee, EmployeeDto> {

    abstract override fun convertToDto(entity: Employee): EmployeeDto

    abstract override fun convertToEntity(dto: EmployeeDto): Employee

}