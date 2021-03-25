package com.zubayr.service.control.resource

import com.zubayr.service.control.api.model.PlanDto
import com.zubayr.service.control.api.resource.PlanResource
import com.zubayr.service.control.service.PlanService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.util.*

@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
class PlanResourceImpl(
        private val planService: PlanService
) : PlanResource {

    override fun getById(id: UUID): ResponseEntity<PlanDto> = ResponseEntity.ok().body(planService.getById(id))

    override fun getAll(): ResponseEntity<List<PlanDto>> = ResponseEntity.ok(planService.getAll())

    override fun getByDate(date: String) = ResponseEntity.ok().body(planService.getByDate(date))

    override fun add(dto: PlanDto) = ResponseEntity.ok(planService.add(dto))

    override fun put(dto: PlanDto): ResponseEntity<PlanDto> {
        TODO("Not yet implemented")
    }
    override fun delete(id: UUID): ResponseEntity<PlanDto> {
        TODO("Not yet implemented")
    }

    override fun downloadPlanFile(file: MultipartFile): ResponseEntity<Boolean> = ResponseEntity.ok().body(planService.downloadPlanFile(file))
}