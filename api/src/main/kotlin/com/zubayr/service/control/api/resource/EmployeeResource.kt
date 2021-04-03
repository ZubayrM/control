package com.zubayr.service.control.api.resource

import com.zubayr.service.control.api.model.EmployeeDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.util.*

@RequestMapping("/employee")
interface EmployeeResource{

    @GetMapping("/operation/{id}")
    fun getByOperationId(@PathVariable id: UUID): ResponseEntity<List<EmployeeDto>>

}