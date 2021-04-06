package com.zubayr.service.control.resource

import com.zubayr.service.control.api.model.EmployeeDto
import com.zubayr.service.control.api.model.OperationDto
import com.zubayr.service.control.api.resource.EmployeeResource
import com.zubayr.service.control.service.EmployeeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestBody
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

    override fun addEmployee(employeeDto: EmployeeDto) {
        employeeService.add(employeeDto)
    }

    override fun addOperation(employee_id: UUID, operations: List<UUID>) {
        employeeService.addOperations(employee_id, operations)
    }

    override fun deleteOperation(employee_id: UUID, operations: List<UUID>) {
        employeeService.deleteOperations(employee_id, operations)
    }
}