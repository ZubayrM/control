package com.zubayr.service.control.api.resource

import com.zubayr.service.control.api.model.SetupOperationDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus

@RequestMapping("/infoOperation")
interface InfoOperationResource {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun add(@RequestBody infoDto: SetupOperationDto)
}