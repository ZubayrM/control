package com.zubayr.service.control.api.model

import com.zubayr.service.control.domain.model.Enum.StageEnum

data class DetailDto(
        var name: String? = null,
        var cipher: String? = null,
        var route: String? = null,
        var material: String? = null,
        var product: ProductDto? = null,
        var stage: StageEnum? = null,
        var operations: List<OperationDto>? = null
) : BaseDto()