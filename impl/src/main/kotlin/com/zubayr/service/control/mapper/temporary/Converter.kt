package com.zubayr.service.control.mapper.temporary

interface Converter<M,D> {

    fun toModel (dto: D): M

    fun toDto(model: M): D
}