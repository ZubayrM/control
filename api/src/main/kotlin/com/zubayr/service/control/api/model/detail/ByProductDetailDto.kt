package com.zubayr.service.control.api.model.detail

import com.zubayr.service.control.api.model.DetailDto

/**

Create by Zubayr on 01.04.2021.

 **/
data class ByProductDetailDto(
    var name: String? = null,
    var cipher: String? = null,
    var sizeNotDone: Int? = null,
    var sizeInWork: Int? = null,
    var sizeCompleted: Int? = null
)
