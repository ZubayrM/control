package com.zubayr.service.control.api.resource

import com.zubayr.service.control.api.model.PlanDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.util.*

@RequestMapping("/plan")
interface PlanResource {

    @GetMapping("/{id}")
    fun getById(@PathVariable id:UUID): ResponseEntity<PlanDto>

    @GetMapping("/byDate")
    fun getByDate(@RequestParam date: String): ResponseEntity<PlanDto>

    @GetMapping()
    fun getAll(): ResponseEntity<List<PlanDto>>

    @PostMapping
    fun add(@RequestBody dto: PlanDto): ResponseEntity<PlanDto>

    @PutMapping
    fun put(@RequestBody dto: PlanDto): ResponseEntity<PlanDto>

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID): ResponseEntity<PlanDto>

    @PostMapping("/download")
    fun downloadPlanFile(@RequestParam file: MultipartFile): ResponseEntity<Boolean>

}