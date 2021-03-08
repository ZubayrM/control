package com.zubayr.service.control.api.model.detail

data class ProductAndListDetailDto(
        var name: String? = null,
        var cipher: String? = null,
        var list: List<ListDetailDto> = ArrayList(),
        var ready: Int? = null
)
