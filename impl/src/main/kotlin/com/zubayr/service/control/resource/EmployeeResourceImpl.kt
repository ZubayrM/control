package com.zubayr.service.control.resource

import com.zubayr.service.control.api.model.EmployeeDto
import com.zubayr.service.control.api.resource.EmployeeResource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.util.*
@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
class EmployeeResourceImpl: EmployeeResource {

    override fun getById(id: UUID): ResponseEntity<EmployeeDto> {
        TODO("Not yet implemented")
    }

    override fun getByName(name: String): ResponseEntity<List<EmployeeDto>> {
        TODO("Not yet implemented")
    }

    override fun getByDetail(id: UUID): ResponseEntity<EmployeeDto> {
        TODO("Not yet implemented")
    }

    override fun add(dto: EmployeeDto): ResponseEntity<EmployeeDto> {
        TODO("Not yet implemented")
    }

    override fun addAll(file: MultipartFile): ResponseEntity<List<EmployeeDto>> {
        TODO("Not yet implemented")
    }

    override fun put(dto: EmployeeDto): ResponseEntity<EmployeeDto> {
        TODO("Not yet implemented")
    }

    override fun delete(id: UUID): ResponseEntity<Boolean> {
        TODO("Not yet implemented")
    }
}