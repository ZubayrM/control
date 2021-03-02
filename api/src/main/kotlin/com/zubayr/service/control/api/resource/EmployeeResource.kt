package com.zubayr.service.control.api.resource

import com.zubayr.service.control.api.model.EmployeeDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.util.*

@RequestMapping("/employee")
interface EmployeeResource{

    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID): ResponseEntity<EmployeeDto>

    @GetMapping
    fun getByName(@RequestParam name: String): ResponseEntity<List<EmployeeDto>>

    @GetMapping("/detail/{id}")
    fun getByDetail(@PathVariable id: UUID): ResponseEntity<EmployeeDto>//----------?

    @PostMapping
    fun add(@RequestBody dto: EmployeeDto): ResponseEntity<EmployeeDto>

    @PostMapping("/addAll")
    fun addAll(@RequestParam file: MultipartFile): ResponseEntity<List<EmployeeDto>>

    @PutMapping
    fun put(@RequestBody dto: EmployeeDto): ResponseEntity<EmployeeDto>

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID): ResponseEntity<Boolean>
}