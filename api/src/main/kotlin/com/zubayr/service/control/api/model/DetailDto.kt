package com.zubayr.service.control.api.model

import java.util.*


data class DetailDto(
        val id: UUID? = null,
        val name: String? = null,
        val cipher: String? = null,
        val route: String? = null,
        val material: String? = null
//        val product: ProductDto? = null,
//        val stage: StageEnum? = null,
//        val operations: List<OperationDto>? = null
)