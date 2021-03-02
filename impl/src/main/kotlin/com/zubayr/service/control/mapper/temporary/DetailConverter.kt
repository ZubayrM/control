package com.zubayr.service.control.mapper.temporary

import com.zubayr.service.control.api.model.DetailDto
import com.zubayr.service.control.domain.model.Detail
import org.springframework.stereotype.Component

@Component
class DetailConverter: Converter<Detail, DetailDto> {

    override fun toModel(dto: DetailDto): Detail {
        return Detail(id = dto.id, name = dto.name, cipher = dto.cipher, route = dto.route, material = dto.material)
    }

    override fun toDto(model: Detail): DetailDto {
        return DetailDto(id = model.id, name = model.name, cipher = model.cipher, route = model.route, material = model.material)
    }
}