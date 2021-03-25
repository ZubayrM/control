package com.zubayr.service.control.service

import com.zubayr.service.control.api.model.DetailDto
import com.zubayr.service.control.api.model.DetailsStatusDto
import com.zubayr.service.control.domain.model.Enum.StageStatusEnum
import com.zubayr.service.control.mapper.DetailMapper
import com.zubayr.service.control.repository.DetailRepository
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Service
import java.util.*

@Service
class DetailService(
        private val detailRepository: DetailRepository
) {

    private val detailMapper = Mappers.getMapper(DetailMapper::class.java)

    fun getById(id: UUID) = detailRepository.getById(id).let { detailMapper.convertToDto(it) }

    fun getAllByProductId(id: UUID): List<DetailDto> = detailRepository.getAllByProductId(id)
            .map { detailMapper.convertToDto(it) }

    fun getStatusByProductId(id: UUID) = DetailsStatusDto(
            completeDetails = detailRepository.countDetailByProductIdAndStage(id, StageStatusEnum.COMPLETED),
            inWorkDetails = detailRepository.countDetailByProductIdAndStage(id, StageStatusEnum.IN_WORK),
            notDoneDetails = detailRepository.countDetailByProductIdAndStage(id, StageStatusEnum.NOT_DONE)
    )

}