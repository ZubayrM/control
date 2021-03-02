package com.zubayr.service.control.mapper

import com.zubayr.service.control.api.model.ProductDto
import com.zubayr.service.control.domain.model.Product
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

//@Mapper
interface ProductConverter {

    @Mappings(
            Mapping(source = "id", target = "id"),
            Mapping(source = "name", target = "name"),
            Mapping(source = "cipher", target = "cipher")
    )
    fun convertToDto(product: Product): ProductDto


    @Mappings(
            Mapping(source = "name", target = "name"),
            Mapping(source = "cipher", target = "cipher")
    )
    fun convertToModel(dto: ProductDto): Product
}