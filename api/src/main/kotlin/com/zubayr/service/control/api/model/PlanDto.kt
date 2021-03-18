package com.zubayr.service.control.api.model


data class PlanDto(
        var startDate: String? = null,
        var endDate: String? = null,
        var realEndDate: String? = null,
        var products: List<ProductDto>? = null
) : BaseDto()
