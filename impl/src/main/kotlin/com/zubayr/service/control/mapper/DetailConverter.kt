package com.zubayr.service.control.mapper

import com.zubayr.service.control.api.model.DetailDto
import com.zubayr.service.control.domain.model.Detail
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings


//@Mapper
interface DetailConverter {


    @Mappings(
        Mapping(source = "id", target = "id"),
        Mapping(source = "name", target = "name"),
        Mapping(source = "cipher", target = "cipher"),
        Mapping(source = "route", target = "route"),
        Mapping(source = "material", target = "material"),
        Mapping(target = "operations", ignore = true)
    )
    fun convertToDto(detail: Detail): DetailDto


//    @Mappings(
//            Mapping(source = "name", target = "name"),
//            Mapping(source = "cipher", target = "cipher"),
//            Mapping(source = "route", target = "route"),
//            Mapping(source = "material", target = "material")
//    )
    @InheritInverseConfiguration
    fun convertToModel(dto: DetailDto): Detail

}