package com.zubayr.service.control.service

import com.zubayr.service.control.api.model.DetailsStatusDto
import com.zubayr.service.control.domain.model.Enum.StageEnum
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

    fun getStatusByProductId(id: UUID) = DetailsStatusDto(
            completeDetails = detailRepository.countDetailByProductIdAndAndStage(id, StageStatusEnum.COMPLETED),
            notDoneDetails = detailRepository.countDetailByProductIdAndAndStage(id, StageStatusEnum.NOT_DONE)
    )

}