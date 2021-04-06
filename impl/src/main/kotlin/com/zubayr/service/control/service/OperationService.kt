package com.zubayr.service.control.service

import com.zubayr.service.control.api.model.EmployeeDto
import com.zubayr.service.control.api.model.OperationDto
import com.zubayr.service.control.domain.model.Operation
import com.zubayr.service.control.mapper.OperationMapper
import com.zubayr.service.control.repository.OperationRepository
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Service
import java.util.*


@Service
class OperationService(
        private val operationRepository: OperationRepository
) {

    private val operationMapper = Mappers.getMapper(OperationMapper::class.java)

    fun getOperationByDetailCipher(cipher: String): List<OperationDto> {
        return operationRepository.getAllByCipherDetail(cipher).map { operationMapper.convertToDto(it) }
    }

    fun add(operationDto: OperationDto) {
        operationRepository.save(operationMapper.convertToEntity(operationDto))
    }

    fun getAllOperations(operations: List<UUID>): List<Operation> {
        return operations.map { operationRepository.getById(it) }
    }

    fun getById(id: UUID): OperationDto {
        return operationRepository.getById(id).let { operationMapper.convertToDto(it) }
    }
}