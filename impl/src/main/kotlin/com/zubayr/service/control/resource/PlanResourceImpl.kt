package com.zubayr.service.control.resource

import com.zubayr.service.control.api.model.PlanDto
import com.zubayr.service.control.api.resource.PlanResource
import com.zubayr.service.control.domain.model.Plan
import com.zubayr.service.control.mapper.temporary.PlanConverter
import com.zubayr.service.control.repository.PlanRepo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class PlanResourceImpl(private val planRepo: PlanRepo): PlanResource {
    override fun getById(id: UUID): ResponseEntity<PlanDto> {
        val result = planRepo.findById(id).get()
        return ResponseEntity.ok(PlanDto(result.id, result.startDate.toString(), result.endDate.toString(), result.realEndDate.toString()))
    }

    override fun getByDate(date: String): ResponseEntity<PlanDto> {
        TODO("Not yet implemented")
    }

    override fun add(dto: PlanDto): ResponseEntity<PlanDto> {
        val converter = PlanConverter()
        val save = planRepo.save(converter.toModel(dto))
        return ResponseEntity.ok(converter.toDto(save))

    }

    override fun put(dto: PlanDto): ResponseEntity<PlanDto> {
        TODO("Not yet implemented")
    }

    override fun delete(id: UUID): ResponseEntity<PlanDto> {
        TODO("Not yet implemented")
    }
}