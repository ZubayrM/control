package com.zubayr.service.control.service

import com.zubayr.service.control.api.model.EmployeeDto
import com.zubayr.service.control.repository.EmployeeRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class EmployeeService(
        private val employeeRepository: EmployeeRepository
) {
    fun getEmployeesByOperationId(id: UUID): List<EmployeeDto> {
        employeeRepository.
    }
}