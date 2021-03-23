package com.zubayr.service.control.api.resource

import com.zubayr.service.control.api.model.OperationInfoDto
import com.zubayr.service.control.api.model.SetupOperationDto
import org.hibernate.mapping.Set
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RequestMapping("/operation")
interface OperationResource {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun add(@RequestBody infoDto: SetupOperationDto)
}