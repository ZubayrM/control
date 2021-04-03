package com.zubayr.service.control.service

import com.zubayr.service.control.api.model.OperationDto
import com.zubayr.service.control.mapper.DetailMapper
import com.zubayr.service.control.mapper.OperationMapper
import com.zubayr.service.control.repository.OperationRepository
import org.springframework.stereotype.Service


@Service
class OperationService(
        private val operationRepository: OperationRepository
) {

    private val operationMapper = Mapper.getMapper(OperationMapper::class.java)

    fun getOperationByDetailCipher(cipher: String): List<OperationDto> {
        return operationRepository.getAllByCipherDetail(cipher).map { operationMapper.convertToDto(it) }
    }
}