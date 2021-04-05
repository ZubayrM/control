package com.zubayr.service.control.api.resource

import com.zubayr.service.control.api.model.OperationDto
import com.zubayr.service.control.api.model.SetupOperationDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RequestMapping("/operation")
interface OperationResource {

    @GetMapping("/detail")
    fun getOperationByDetailId(@RequestParam(name = "cipher") cipher:String): ResponseEntity<List<OperationDto>>

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addOperation(operationDto: OperationDto)
}