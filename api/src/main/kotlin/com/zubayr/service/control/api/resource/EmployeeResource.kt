package com.zubayr.service.control.api.resource

import com.zubayr.service.control.api.model.EmployeeDto
import com.zubayr.service.control.api.model.OperationDto
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.util.*

@RequestMapping("/employee")
interface EmployeeResource{

    @GetMapping("/operation/{id}")
    fun getByOperationId(@PathVariable id: UUID): ResponseEntity<List<EmployeeDto>>

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun addEmployee(@RequestBody employeeDto: EmployeeDto)

    @PostMapping("{employee_id}/operation",produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun addOperation(@PathVariable employee_id: UUID, @RequestBody operations: List<UUID>)

    @DeleteMapping("{employee_id}/operation",produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun deleteOperation(@PathVariable employee_id: UUID, @RequestBody operations: List<UUID>)
}