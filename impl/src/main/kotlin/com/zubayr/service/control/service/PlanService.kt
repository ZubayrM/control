package com.zubayr.service.control.service

import com.zubayr.service.control.api.model.PlanDto
import com.zubayr.service.control.mapper.PlanMapper
import com.zubayr.service.control.parser.XLSXParser
import com.zubayr.service.control.repository.PlanRepository
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.time.LocalDate
import java.util.*

@Service
class PlanService(
        private val planRepository: PlanRepository,
        private val parser: XLSXParser
) {

    private val planMapper: PlanMapper = Mappers.getMapper(PlanMapper::class.java)

    fun getById(id: UUID) = planRepository.getById(id)?.let {
        planMapper.convertToDto(it)
    }

    fun getByDate(date: String) = planRepository.findByStartDate(LocalDate.parse(date))?.let { planMapper.convertToDto(it) }

    fun getAll() = planRepository.findAll().map { plan -> planMapper.convertToDto(plan) }.toList()

    fun add(dto: PlanDto) = planRepository.save(planMapper.convertToEntity(dto)).let { planMapper.convertToDto(it) }

    fun put(dto: PlanDto): PlanDto {
        TODO("Not yet implemented")
    }

    fun delete(id: UUID): PlanDto {
        TODO("Not yet implemented")
    }

    fun downloadPlanFile(file: MultipartFile): Boolean {
        println(parser.parse(file))
        return true
    }
}