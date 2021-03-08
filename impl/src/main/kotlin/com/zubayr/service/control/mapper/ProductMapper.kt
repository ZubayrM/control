package com.zubayr.service.control.mapper

import com.zubayr.service.control.api.model.ProductDto
import com.zubayr.service.control.domain.model.Product
import org.mapstruct.Mapper

@Mapper
abstract class ProductMapper : BaseMapper<Product, ProductDto>{

    abstract override fun convertToDto(entity: Product): ProductDto

    abstract override fun convertToEntity(dto: ProductDto): Product
}