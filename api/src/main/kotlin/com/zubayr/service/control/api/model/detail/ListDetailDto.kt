package com.zubayr.service.control.api.model.detail

import com.zubayr.service.control.api.model.DetailDto

data class ListDetailDto(
        var name: String? = null,
        var cipher: String? = null,
        var list: List<DetailDto> = ArrayList()
)
