package com.zubayr.service.control.api.model.detail

import com.zubayr.service.control.api.model.DetailDto

data class ListDetailDto (
    val name: String? = null,
    val cipher: String? = null,
    val list: List<DetailDto> = ArrayList()


        )
