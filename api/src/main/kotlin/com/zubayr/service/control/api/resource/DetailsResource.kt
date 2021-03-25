package com.zubayr.service.control.api.resource

import com.zubayr.service.control.api.model.DetailDto
import com.zubayr.service.control.api.model.DetailsStatusDto
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import java.util.*

@RequestMapping("/detail")
interface DetailsResource {

    @GetMapping("/{id}")
    fun getById(@PathVariable id:UUID): ResponseEntity<DetailDto>

    @GetMapping("/product/{id}")
    fun getAllByProductId(@PathVariable id:UUID): ResponseEntity<List<DetailDto>>

    @GetMapping("/productStatus/{id}")
    fun getStatusByProductId(@PathVariable id:UUID): ResponseEntity<DetailsStatusDto>




//    @GetMapping("/{id}")
//    fun getById(@PathVariable id: UUID): ResponseEntity<DetailDto>
//
//    @GetMapping("/byCipher")
//    fun getByCipher(@RequestParam cipher: String): ResponseEntity<DetailDto>
//
//    @GetMapping("/byName")
//    fun getByName(@RequestParam name: String): ResponseEntity<ArrayList<ListDetailDto>>
//
//    @GetMapping("/byEmployee/{id}")
//    fun getByEmployee(@PathVariable id: UUID): ResponseEntity<List<DetailDto>> //------------?
//
//    @GetMapping("/byProduct/{id}")
//    fun getByProduct(@PathVariable id: UUID): ResponseEntity<List<DetailDto>>
//
//    @GetMapping("/byPlan/{id}")
//    fun getAllByPlan(@PathVariable id: UUID): ResponseEntity<List<ProductAndListDetailDto>>
//
//    @PostMapping
//    fun add(@RequestBody dto: DetailDto): ResponseEntity<DetailDto>
//
//    @PostMapping("/addAll")
//    fun addAll(@RequestParam file: MultipartFile): ResponseEntity<List<DetailDto>>
//
//    @PutMapping
//    fun put(@RequestBody dto: DetailDto): ResponseEntity<DetailDto>
//
//    @DeleteMapping("/{id}")
//    fun delete(@PathVariable id: UUID): ResponseEntity<Boolean>
}