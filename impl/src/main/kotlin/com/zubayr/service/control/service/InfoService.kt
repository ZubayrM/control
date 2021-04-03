package com.zubayr.service.control.service

import com.zubayr.service.control.api.model.SetupOperationDto
import com.zubayr.service.control.domain.model.Enum.StageStatusEnum
import com.zubayr.service.control.domain.model.InfoOperation
import com.zubayr.service.control.repository.DetailRepository
import com.zubayr.service.control.repository.EmployeeRepository
import com.zubayr.service.control.repository.InfoOperationRepository
import com.zubayr.service.control.repository.OperationRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.ZonedDateTime

/**
 * InfoService
 *
 * @author Denis_Kholmogorov
 */
@Service
class InfoService(
        private val detailRepository: DetailRepository,
        private val operationRepository: OperationRepository,
        private val employeeRepository: EmployeeRepository,
        private val infoOperationRepository: InfoOperationRepository
) {

    @Transactional
    fun add(operationDto: SetupOperationDto) {

        val details = detailRepository.getByProductIdAndCipherAndStage(
                operationDto.productId, operationDto.detailCipher, StageStatusEnum.NOT_DONE.ordinal
        ).take(operationDto.countDetails)

        details.forEach { detail ->
            val employee = employeeRepository.getById(operationDto.employeeId)
            val operation = operationRepository.getById(operationDto.operationId)
            val info = infoOperationRepository.save(
                    InfoOperation(
                            operation = operation,
                            stage = StageStatusEnum.NOT_DONE,
                            employee = employee,
                            detail = detail,
                            startTime = ZonedDateTime.now())
            )
            detail.stage = StageStatusEnum.IN_WORK
            detail.startTime = ZonedDateTime.now()
            detail.infoOperations?.add(info)
            employee.infoOperations?.add(info)
            employeeRepository.save(employee)

        }
        detailRepository.saveAll(details)
    }
}