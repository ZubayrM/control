package com.zubayr.service.control.api.resource

import com.zubayr.service.control.api.model.OperationDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RequestMapping("/operation")
interface OperationResource {

    @GetMapping
    fun getByDetail(@RequestParam cipher: String): ResponseEntity<List<OperationDto>>

    @PostMapping
    fun add(@RequestBody dto: OperationDto): ResponseEntity<OperationDto>

    @PutMapping
    fun put(@RequestBody dto: OperationDto): ResponseEntity<OperationDto>

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID): ResponseEntity<Boolean>
}