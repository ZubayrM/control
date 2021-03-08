package com.zubayr.service.control.mapper

import com.zubayr.service.control.api.model.DetailDto
import com.zubayr.service.control.domain.model.Detail
import org.mapstruct.*


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
abstract class DetailMapper : BaseMapper<Detail, DetailDto> {

    abstract override fun convertToDto(entity: Detail): DetailDto

    abstract override fun convertToEntity(dto: DetailDto): Detail

}