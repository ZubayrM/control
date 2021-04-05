package com.zubayr.service.control.api.model

data class DetailDto(
        var name: String? = null,
        var cipher: String? = null,
        var route: String? = null,
        var material: String? = null,
        var product: ProductDto? = null,
        var stage: StageDetailEnumDto? = null,
        var operations: List<OperationDto>? = null
) : BaseDto()

enum class StageDetailEnumDto {

    NOT_DONE,

    IN_WORK,

    COMPLETED,

    BROKEN
}

