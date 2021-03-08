package com.zubayr.service.control.api.resource

import com.zubayr.service.control.api.model.PlanDto
import com.zubayr.service.control.api.model.ProductDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RequestMapping("/product")
interface ProductResource {

    @GetMapping("/{id}")
    fun geById(@PathVariable id: UUID): ResponseEntity<ProductDto>

    @GetMapping("/cipher")
    fun getByCipher(@RequestParam cipher: String): ResponseEntity<ProductDto>

    @PostMapping
    fun add(@RequestBody dto: PlanDto): ResponseEntity<ProductDto>

    @PutMapping
    fun put(@RequestBody dto: PlanDto): ResponseEntity<ProductDto>

    @DeleteMapping
    fun delete(@PathVariable id: UUID): ResponseEntity<Boolean>
}