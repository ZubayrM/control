package com.zubayr.service.control.resource

import com.zubayr.service.control.api.model.EmployeeDto
import com.zubayr.service.control.api.resource.EmployeeResource
import com.zubayr.service.control.service.EmployeeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.util.*
@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
class EmployeeResourceImpl(
        private val employeeService: EmployeeService
): EmployeeResource {

    override fun getByOperationId(id: UUID): ResponseEntity<List<EmployeeDto>> {
        return ResponseEntity.ok(employeeService.getEmployeesByOperationId(id))
    }
}