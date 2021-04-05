package com.zubayr.service.control.service

import com.zubayr.service.control.api.model.EmployeeDto
import com.zubayr.service.control.api.model.OperationDto
import com.zubayr.service.control.mapper.EmployeeMapper
import com.zubayr.service.control.mapper.OperationMapper
import com.zubayr.service.control.repository.EmployeeRepository
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class EmployeeService(
        private val employeeRepository: EmployeeRepository,
        private val operationService: OperationService
) {

    private val employeeMapper = Mappers.getMapper(EmployeeMapper::class.java)
    private val operationMapper = Mappers.getMapper(OperationMapper::class.java)

    fun getEmployeesByOperationId(id: UUID): List<EmployeeDto> {
        //TODO employeeRepository.
        return emptyList()
    }

    fun add(employeeDto: EmployeeDto) {
        employeeRepository.save(employeeMapper.convertToEntity(employeeDto))
    }

    @Transactional
    fun addOperations(employeeId: UUID, operations: List<UUID>) {
        employeeRepository.getById(employeeId = employeeId)
                .let { employee ->
            operationService
                    .getAllOperations(operations).forEach { operation -> employee.addOperation(operation) }
        }
    }
}