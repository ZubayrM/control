package com.zubayr.service.control.mapper

import com.zubayr.service.control.api.model.EmployeeDto
import com.zubayr.service.control.domain.model.Employee
import com.zubayr.service.control.domain.model.Enum.ProfessionEnum
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

//@Mapper
interface EmployeeConverter {
    @Mappings(
            Mapping(source = "id", target = "id"),
            Mapping(source = "name", target = "name"),
            Mapping(source = "surname", target = "surname"),
            Mapping(dateFormat = "dd.MM.yyyy", target = "dataOfBirth" ),
            Mapping(source = "profession", target = "professionEnum", expression = "getProfession(profession)")
    )
    fun convertToDto(employee: Employee): EmployeeDto


    @Mappings(
            Mapping(source = "name", target = "name"),
            Mapping(source = "surname", target = "surname"),
            Mapping(source = "dataOfBirth", target = "dataOfBirth"),
            Mapping(source = "professionEnum", target = "profession")
    )
    fun convertToModel(dto: EmployeeDto): Employee

    fun getProfession (dto: EmployeeDto): ProfessionEnum? {
        return dto.professionEnum
    }
}