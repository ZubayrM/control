package com.zubayr.service.control.api.model

data class ProductDto(
        var name: String? = null,
        var cipher: String? = null,
        var details: List<DetailDto>? = null
) : BaseDto()